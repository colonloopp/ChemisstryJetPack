package com.chemisstry.chemisstry.fragment.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.Animation
import android.view.animation.Animation.AnimationListener
import android.view.animation.AnimationUtils
import androidx.fragment.app.Fragment
import com.chemisstry.chemisstry.R
import com.chemisstry.chemisstry.util.MyBounceInterpolator
import kotlinx.android.synthetic.main.fragment_search.*


class SearchFragment : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_search, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        animateButton()
    }


    fun animateButton() {
        // Load the animation
        val myAnim: Animation = AnimationUtils.loadAnimation(activity, R.anim.bounce)
        val animationDuration: Double = 2.0 * 1000
        myAnim.duration = animationDuration.toLong()

        // Use custom animation interpolator to achieve the bounce effect
        val interpolator = MyBounceInterpolator(0.2, 8.0)
        myAnim.interpolator = interpolator

        // Animate the button
        waiting_circle_layout.startAnimation(myAnim)

        // Run button animation again after it finished
        myAnim.setAnimationListener(object : AnimationListener {
            override fun onAnimationStart(arg0: Animation) {}
            override fun onAnimationRepeat(arg0: Animation) {}
            override fun onAnimationEnd(arg0: Animation) {
                // animateButton()
            }
        })
    }
}