package com.chemisstry.chemisstry.fragment.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import com.chemisstry.chemisstry.R
import kotlinx.android.synthetic.main.fragment_settings.*

class SettingsFragment : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? =
        inflater.inflate(R.layout.fragment_settings, container, false)

    companion object {
        fun newInstance(): SettingsFragment = SettingsFragment()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        // setUpListeners()
    }


    private fun setUpListeners() {
        btn_fragment_general_account?.setOnClickListener {
            val direction = SettingsFragmentDirections.settingsToGeneralAccount()
            direction.mail = "user@email.com"
            Navigation.findNavController(btn_fragment_general_account).navigate(direction)
        }


    }


}