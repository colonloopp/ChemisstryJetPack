package com.chemisstry.chemisstry.fragment.welcome

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import com.chemisstry.chemisstry.LandingActivity
import com.chemisstry.chemisstry.R
import kotlinx.android.synthetic.main.fragment_welcome.*

class WelcomeFragment : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_welcome, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setUpListeners()
    }

    private fun setUpListeners() {
        btn_fragment_login?.setOnClickListener(Navigation.createNavigateOnClickListener(R.id.nav_fragment_login))
        btn_fragment_authenticity?.setOnClickListener(Navigation.createNavigateOnClickListener(R.id.nav_fragment_authenticity))


        btn_activity_landing.setOnClickListener {
            val intent = Intent(activity, LandingActivity::class.java)
            startActivity(intent)
        }

    }

}