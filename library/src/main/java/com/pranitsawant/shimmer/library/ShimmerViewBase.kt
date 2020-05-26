package com.pranitsawant.shimmer.library

import android.text.BoringLayout

interface ShimmerViewBase {
    fun getGradientX() : Float

    fun setGradientX(gradientX: Float)

    fun isShimmering() : Boolean

    fun isSetUp() : Boolean

    fun getPrimaryColor() : Int

    fun setAnimationSetupCallback(callback: ShimmerViewHelper.AnimationSetupCallback)

    fun setPrimaryColor(primaryColor: Int)

    fun getReflectionColor() : Int

    fun setReflectionColor(reflectionColor: Int)
}