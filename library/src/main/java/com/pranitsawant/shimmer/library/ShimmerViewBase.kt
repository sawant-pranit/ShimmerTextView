package com.pranitsawant.shimmer.library

interface ShimmerViewBase {
    fun getGradientX() : Float

    fun setGradientX(gradientX: Float)

    fun setShimmering(isShimmering: Boolean)

    fun isShimmering() : Boolean

    fun isSetUp() : Boolean

    fun getPrimaryColor() : Int

    fun setAnimationSetupCallback(callback: ShimmerViewHelper.AnimationSetupCallback)

    fun setPrimaryColor(primaryColor: Int)

    fun getReflectionColor() : Int

    fun setReflectionColor(reflectionColor: Int)
}