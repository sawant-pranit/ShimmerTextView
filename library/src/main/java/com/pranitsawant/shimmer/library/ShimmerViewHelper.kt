package com.pranitsawant.shimmer.library

import android.view.View

class ShimmerViewHelper {

    interface AnimationSetupCallback{
        fun onSetAnimation(target: View)
    }
}