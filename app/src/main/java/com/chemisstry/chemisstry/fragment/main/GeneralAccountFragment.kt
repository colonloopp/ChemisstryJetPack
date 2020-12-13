package com.chemisstry.chemisstry.fragment.main

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.chemisstry.chemisstry.MainActivity
import com.chemisstry.chemisstry.R
import kotlinx.android.synthetic.main.fragment_general_account.*

class GeneralAccountFragment : Fragment() {

    lateinit var userEmail: String
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_general_account, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setValues()
        setUpListeners()
    }

    private fun setUpListeners() {

        btn_fragment_logout.setOnClickListener {
            val intent = Intent(activity, MainActivity::class.java)
            intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
            startActivity(intent)
        }

    }

    private fun setValues() {
        val args: GeneralAccountFragmentArgs? = arguments?.let {
            GeneralAccountFragmentArgs.fromBundle(it)
        }
        args?.let {
            userEmail = it.mail.toString()
            tv_fragment_two.text = "User Email : $userEmail "
        }
    }


}