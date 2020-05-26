package com.pranitsawant.shimmer.library

import android.animation.Animator
import android.animation.ObjectAnimator
import android.animation.ValueAnimator

class Shimmer {
    companion object {
        val ANIMATION_DIRECTION_LTR = 0
        val ANIMATION_DIRECTION_RTL = 1

        val DEFAULT_REPEAT_COUNT = ValueAnimator.INFINITE
        val DEFAULT_DURATION : Long = 1000
        val DEFAULT_START_DELAY : Long = 0
        val DEFAULT_DIRECTION : Int= ANIMATION_DIRECTION_LTR
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