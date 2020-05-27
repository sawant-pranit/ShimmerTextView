package com.pranitsawant.shimmer.library

import android.content.Context
import android.content.res.ColorStateList
import android.graphics.Canvas
import android.util.AttributeSet
import androidx.appcompat.widget.AppCompatTextView
import com.pranitsawant.shimmer.library.ShimmerViewHelper.AnimationSetupCallback

class ShimmerTextView : AppCompatTextView, ShimmerViewBase {
    private var shimmerViewHelper: ShimmerViewHelper?

    constructor(context: Context?) : super(context) {
        shimmerViewHelper = ShimmerViewHelper(this, paint, null)
        shimmerViewHelper!!.setPrimaryColor(currentTextColor)
    }

    constructor(context: Context?, attrs: AttributeSet?) : super(
        context,
        attrs
    ) {
        shimmerViewHelper = ShimmerViewHelper(this, paint, attrs!!)
        shimmerViewHelper!!.setPrimaryColor(currentTextColor)
    }

    constructor(
        context: Context?,
        attrs: AttributeSet?,
        defStyle: Int
    ) : super(context, attrs, defStyle) {
        shimmerViewHelper = ShimmerViewHelper(this, paint, attrs!!)
        shimmerViewHelper!!.setPrimaryColor(currentTextColor)
    }

    override fun getGradientX(): Float {
        return shimmerViewHelper!!.getGradientX()
    }

    override fun setGradientX(gradientX: Float) {
        shimmerViewHelper!!.setGradientX(gradientX)
    }

    override fun isShimmering(): Boolean {
        return shimmerViewHelper!!.isShimmering()
    }

    override fun setShimmering(isShimmering: Boolean) {
        shimmerViewHelper!!.setShimmering(isShimmering)
    }

    override fun isSetUp(): Boolean {
        return shimmerViewHelper!!.isSetUp()
    }

    override fun setAnimationSetupCallback(callback: AnimationSetupCallback) {
        shimmerViewHelper!!.setAnimationSetupCallback(callback)
    }

    override fun getPrimaryColor(): Int {
        return shimmerViewHelper!!.getPrimaryColor()
    }

    override fun setPrimaryColor(primaryColor: Int) {
        shimmerViewHelper!!.setPrimaryColor(primaryColor)
    }

    override fun getReflectionColor(): Int {
        return shimmerViewHelper!!.getReflectionColor()
    }

    override fun setReflectionColor(reflectionColor: Int) {
        shimmerViewHelper!!.setReflectionColor(reflectionColor)
    }

    override fun setTextColor(color: Int) {
        super.setTextColor(color)
        if (shimmerViewHelper != null) {
            shimmerViewHelper!!.setPrimaryColor(currentTextColor)
        }
    }

    override fun setTextColor(colors: ColorStateList) {
        super.setTextColor(colors)
        if (shimmerViewHelper != null) {
            shimmerViewHelper!!.setPrimaryColor(currentTextColor)
        }
    }

    override fun onSizeChanged(w: Int, h: Int, oldw: Int, oldh: Int) {
        super.onSizeChanged(w, h, oldw, oldh)
        if (shimmerViewHelper != null) {
            shimmerViewHelper!!.onSizeChanged()
        }
    }

    public override fun onDraw(canvas: Canvas) {
        if (shimmerViewHelper != null) {
            shimmerViewHelper!!.onDraw()
        }
        super.onDraw(canvas)
    }
}