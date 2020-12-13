package com.chemisstry.chemisstry.fragment.welcome

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import com.chemisstry.chemisstry.R
import kotlinx.android.synthetic.main.fragment_login.*


class LoginFragment : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_login, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setUpListeners()
    }

    private fun setUpListeners() {
        btn_fragment_forget_password?.setOnClickListener(Navigation.createNavigateOnClickListener(R.id.nav_fragment_forget_password))


    }


}