package com.chemisstry.chemisstry

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.NavigationUI
import com.chemisstry.chemisstry.R
import com.google.android.material.bottomnavigation.BottomNavigationView

class LandingActivity : AppCompatActivity() {
    var bottomNavigationView: BottomNavigationView? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_landing)
        setUpNavigation()
    }

    fun setUpNavigation() {
        bottomNavigationView = findViewById(R.id.bttm_nav)
        val navHostFragment = supportFragmentManager
            .findFragmentById(R.id.nav_host_fragment) as NavHostFragment?
        NavigationUI.setupWithNavController(
            bottomNavigationView!!,
            navHostFragment!!.navController
        )
        navHostFragment.navController.navigate(R.id.nav_fragment_chat)

    }
}