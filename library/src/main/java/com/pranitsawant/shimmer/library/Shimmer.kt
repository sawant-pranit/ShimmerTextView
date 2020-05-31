package com.pranitsawant.shimmer.library

import android.animation.Animator
import android.animation.Animator.AnimatorListener
import android.animation.ObjectAnimator
import android.animation.ValueAnimator
import android.os.Build
import android.view.View
import com.pranitsawant.shimmer.library.ShimmerViewHelper.AnimationSetupCallback


class Shimmer {
    companion object {
        const val ANIMATION_DIRECTION_LTR = 0
        const val ANIMATION_DIRECTION_RTL = 1

        const val DEFAULT_REPEAT_COUNT = ValueAnimator.INFINITE
        const val DEFAULT_DURATION: Long = 1000
        const val DEFAULT_START_DELAY: Long = 0
        const val DEFAULT_DIRECTION: Int = ANIMATION_DIRECTION_LTR
    }

    private var repeatCount: Int? = null
    private var duration: Long? = null
    private var startDelay : Long? = null
    private var direction : Int? = null

    private var animatorListener : Animator.AnimatorListener? = null

    private var animator: ObjectAnimator? = null

    init {
        repeatCount = DEFAULT_REPEAT_COUNT
        duration = DEFAULT_DURATION
        startDelay = DEFAULT_START_DELAY
        direction = DEFAULT_DIRECTION
    }



    fun startDelay(startDelay: Long) = apply {this.startDelay = startDelay}

    fun duration(duration: Long) = apply { this.duration = duration }

    fun animationListener(listener : Animator.AnimatorListener)
            = apply{ this.animatorListener = listener }

    fun <V> start(shimmerView: V) where V : View, V : ShimmerViewBase {
        if (isAnimating() == true) {
            return
        }
        val animate = Runnable {
            shimmerView.setShimmering(true)
            var fromX = 0f
            var toX: Float = shimmerView.getWidth().toFloat()
            if (direction === ANIMATION_DIRECTION_RTL) {
                fromX = shimmerView.getWidth().toFloat()
                toX = 0f
            }
            animator = ObjectAnimator.ofFloat(shimmerView, "gradientX", fromX, toX)
            animator?.repeatCount = repeatCount!!
            animator?.duration = duration!!
            animator?.startDelay = startDelay!!
            animator?.addListener(object : AnimatorListener {
                override fun onAnimationStart(animation: Animator) {}
                override fun onAnimationEnd(animation: Animator) {
                    shimmerView.setShimmering(false)
                    if (Build.VERSION.SDK_INT < Build.VERSION_CODES.JELLY_BEAN) {
                        shimmerView.postInvalidate()
                    } else {
                        shimmerView.postInvalidateOnAnimation()
                    }
                    animator = null
                }

                override fun onAnimationCancel(animation: Animator) {}
                override fun onAnimationRepeat(animation: Animator) {}
            })
            if (animatorListener != null) {
                animator?.addListener(animatorListener)
            }
            animator?.start()
        }
        if (!shimmerView!!.isSetUp()) {
            shimmerView.setAnimationSetupCallback(object : AnimationSetupCallback {
                override fun onSetupAnimation(target: View?) {
                    animate.run()
                }
            })
        } else {
            animate.run()
        }
    }

    fun direction(direction: Int) =
        apply {
            if(direction != ANIMATION_DIRECTION_LTR
                && direction != ANIMATION_DIRECTION_RTL) {
                throw IllegalArgumentException(
                    "The animation direction must be either ANIMATION_DIRECTION_LTR " +
                            "or ANIMATION_DIRECTION_RTL"
                )
            }
            this.direction = direction
        }

    fun build() = Shimmer()


    fun cancel() {
        animator?.cancel()
    }

    fun isAnimating() = animator?.isRunning


}