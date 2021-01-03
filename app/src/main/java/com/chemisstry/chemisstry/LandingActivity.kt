package com.chemisstry.chemisstry

import android.os.Bundle
import android.os.Handler
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.chemisstry.chemisstry.fragment.main.ChatFragment
import com.chemisstry.chemisstry.fragment.main.SearchFragment
import com.chemisstry.chemisstry.fragment.main.SettingsFragment
import com.google.android.material.bottomnavigation.BottomNavigationView

class LandingActivity : AppCompatActivity() {
    var bottomNavigationView: BottomNavigationView? = null
    fun getFragmentRefreshListener(): FragmentRefreshListener? {
        return fragmentRefreshListener
    }

    fun setFragmentRefreshListener(fragmentRefreshListener: FragmentRefreshListener?) {
        this.fragmentRefreshListener = fragmentRefreshListener
    }

    private var fragmentRefreshListener: FragmentRefreshListener? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_landing)
        val bottomNavigation: BottomNavigationView = findViewById(R.id.navigationView)
        bottomNavigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener)
        bottomNavigation.selectedItemId = R.id.nav_fragment_search
        Handler().postDelayed({
            if (getFragmentRefreshListener() != null) {
                getFragmentRefreshListener()!!.onRefresh("Data");
            }
        }, 1000 * 30)

    }

    private val mOnNavigationItemSelectedListener =
        BottomNavigationView.OnNavigationItemSelectedListener { item ->
            when (item.itemId) {
                R.id.nav_fragment_search -> {
                    val albumsFragment = SearchFragment.newInstance()
                    openFragment(albumsFragment)
                    return@OnNavigationItemSelectedListener true
                }
                R.id.nav_fragment_chat -> {
                    val albumsFragment = ChatFragment.newInstance()
                    openFragment(albumsFragment)
                    return@OnNavigationItemSelectedListener true
                }
                R.id.nav_fragment_home -> {
                    val albumsFragment = SettingsFragment.newInstance()
                    openFragment(albumsFragment)
                    return@OnNavigationItemSelectedListener true
                }
            }
            false
        }

    private fun openFragment(fragment: Fragment) {
        val transaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.container, fragment)
        transaction.addToBackStack(null)
        transaction.commit()
    }

    interface FragmentRefreshListener {
        fun onRefresh( data: String)
    }


}
