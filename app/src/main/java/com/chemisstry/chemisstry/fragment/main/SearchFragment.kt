package com.chemisstry.chemisstry.fragment.main

import android.os.Bundle
import android.os.Handler
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.Animation
import android.view.animation.Animation.AnimationListener
import android.view.animation.AnimationUtils
import androidx.fragment.app.Fragment
import com.chemisstry.chemisstry.LandingActivity
import com.chemisstry.chemisstry.R
import com.chemisstry.chemisstry.util.CircleAngleAnimation
import com.chemisstry.chemisstry.util.MyBounceInterpolator
import kotlinx.android.synthetic.main.fragment_search.*


class SearchFragment : Fragment() {

    lateinit var circleAnimation: CircleAngleAnimation
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? =
        inflater.inflate(R.layout.fragment_search, container, false)

    companion object {
        fun newInstance(): SearchFragment = SearchFragment()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        (activity as LandingActivity?)!!.setFragmentRefreshListener(object :
            LandingActivity.FragmentRefreshListener {
            override fun onRefresh(data: String) {
                state_four.visibility = View.VISIBLE
                animateState4()
            }
        })
        prepareProgressAnimation()
        connect_button.setOnClickListener {
            preAnimateState1()
            animateState1()
        }
        predicted_time_info.setOnClickListener {
            hideState4()
            animateState3()
        }
    }

    fun animateState1() {
        val aniSlide = AnimationUtils.loadAnimation(
            activity,
            R.anim.zoom_out
        )
        women_button.startAnimation(aniSlide)
        total_button.startAnimation(aniSlide)
        men_button.startAnimation(aniSlide)

        aniSlide.setAnimationListener(object : AnimationListener {
            override fun onAnimationStart(arg0: Animation) {}
            override fun onAnimationRepeat(arg0: Animation) {}
            override fun onAnimationEnd(arg0: Animation) {
                women_button.visibility = View.GONE
                total_button.visibility = View.GONE
                men_button.visibility = View.GONE
                hideState1()
                preanimationState2()
                Handler().postDelayed({
                    finding_circle_layout.visibility = View.VISIBLE
                    this@SearchFragment.animateState2Finding()
                }, 600)

            }
        })
    }

    fun preanimationState2() {
        state_two.visibility = View.VISIBLE
        finding_circle_layout.visibility = View.INVISIBLE
        state_two_finding_heading.visibility = View.INVISIBLE
        state_two_finding_sub_heading.visibility = View.INVISIBLE
        state_two_red_indicator.visibility = View.INVISIBLE
        state_two_yellow_indicator.visibility = View.INVISIBLE
        state_two_green_indicator.visibility = View.INVISIBLE
    }

    fun animateState2Finding() {
        // Load the animation
        val myAnim: Animation = AnimationUtils.loadAnimation(activity, R.anim.bounce)
        val animationDuration: Double = 1.5 * 1000
        myAnim.duration = animationDuration.toLong()

        // Use custom animation interpolator to achieve the bounce effect
        val interpolator = MyBounceInterpolator(0.2, 8.0)
        myAnim.interpolator = interpolator

        // Animate the button
        finding_circle_layout.startAnimation(myAnim)

        myAnim.setAnimationListener(object : AnimationListener {
            override fun onAnimationStart(arg0: Animation) {}
            override fun onAnimationRepeat(arg0: Animation) {}
            override fun onAnimationEnd(arg0: Animation) {
                progress_bar.startAnimation(circleAnimation)

            }
        })
    }

    fun state2IndicatorsVisiblity() {
        Handler().postDelayed({
            state_two_red_indicator.visibility = View.VISIBLE
            Handler().postDelayed({
                state_two_yellow_indicator.visibility = View.VISIBLE
                Handler().postDelayed({
                    state_two_green_indicator.visibility = View.VISIBLE
                    Handler().postDelayed({
                        state_two_finding_heading.visibility = View.VISIBLE
                        Handler().postDelayed({
                            state_two_finding_sub_heading.visibility = View.VISIBLE
                        }, 400)
                    }, 400)
                }, 400)
            }, 400)
        }, 400)
    }

    fun animateState4() {
        hideState2()
        // Load the animation
        val myAnim: Animation = AnimationUtils.loadAnimation(activity, R.anim.bounce)
        val animationDuration: Double = 2.0 * 1000
        myAnim.duration = animationDuration.toLong()

        // Use custom animation interpolator to achieve the bounce effect
        val interpolator = MyBounceInterpolator(0.2, 8.0)
        myAnim.interpolator = interpolator

        // Animate the button
        waiting_circle_layout.startAnimation(myAnim)

        myAnim.setAnimationListener(object : AnimationListener {
            override fun onAnimationStart(arg0: Animation) {}
            override fun onAnimationRepeat(arg0: Animation) {}
            override fun onAnimationEnd(arg0: Animation) {

            }
        })
    }

    fun animateState3() {
        hideState2()
        // Load the animation
        val myAnim: Animation = AnimationUtils.loadAnimation(activity, R.anim.bounce)
        val animationDuration: Double = 1.5 * 1000
        myAnim.duration = animationDuration.toLong()

        // Use custom animation interpolator to achieve the bounce effect
        val interpolator = MyBounceInterpolator(0.2, 8.0)
        myAnim.interpolator = interpolator
        preAnimateState3()
        // Animate the button
        state_three_circle.startAnimation(myAnim)

        myAnim.setAnimationListener(object : AnimationListener {
            override fun onAnimationStart(arg0: Animation) {}
            override fun onAnimationRepeat(arg0: Animation) {}
            override fun onAnimationEnd(arg0: Animation) {

                state3IndicatorsVisibility()
            }
        })
    }

    fun state3IndicatorsVisibility() {
        Handler().postDelayed({
            state_three_red_indicator.visibility = View.VISIBLE
            Handler().postDelayed({
                state_three_yellow_indicator.visibility = View.VISIBLE
                Handler().postDelayed({
                    state_three_green_indicator.visibility = View.VISIBLE
                    Handler().postDelayed({
                        state_three_heading.visibility = View.VISIBLE
                        Handler().postDelayed({
                            state_three_sub_heading.visibility = View.VISIBLE
                        }, 400)
                    }, 400)
                }, 400)
            }, 400)
        }, 400)
    }


    fun preAnimateState3() {
        state_three.visibility = View.VISIBLE
        state_three_heading.visibility = View.INVISIBLE
        state_three_sub_heading.visibility = View.INVISIBLE
        state_three_red_indicator.visibility = View.INVISIBLE
        state_three_yellow_indicator.visibility = View.INVISIBLE
        state_three_green_indicator.visibility = View.INVISIBLE
    }

    fun preAnimateState1() {
        university_name.visibility = View.INVISIBLE
        university_image.visibility = View.INVISIBLE
        women_title.visibility = View.INVISIBLE
        mem_title.visibility = View.INVISIBLE
        total_title.visibility = View.INVISIBLE
        connect_button.visibility = View.INVISIBLE
    }

    fun hideState4() {
        state_four.visibility = View.GONE
    }

    fun hideState3() {
        state_three.visibility = View.GONE
    }

    fun hideState2() {
        state_two.visibility = View.GONE
    }

    fun hideState1() {
        state_one.visibility = View.GONE
    }

    fun prepareProgressAnimation() {
        circleAnimation = CircleAngleAnimation(progress_bar, 360)
        circleAnimation.duration = 5000
        circleAnimation.setAnimationListener(object : AnimationListener {
            override fun onAnimationStart(animation: Animation) {
            }

            override fun onAnimationEnd(animation: Animation) {
                state2IndicatorsVisiblity()
            }

            override fun onAnimationRepeat(animation: Animation) {
            }
        })
    }
}