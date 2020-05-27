package com.pranitsawant.shimmer.sample

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.pranitsawant.shimmer.library.Shimmer
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {


    private var shimmer: Shimmer?=null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnToggle.setOnClickListener{
            if(shimmer != null && shimmer?.isAnimating() == true) {
                shimmer?.cancel()
            } else {
                shimmer = Shimmer()
                shimmer?.start(textView)
            }
        }
    }
}
