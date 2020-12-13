package com.chemisstry.chemisstry.fragment.welcome

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.chemisstry.chemisstry.R
import kotlinx.android.synthetic.main.fragment_user_detail.*


class UserDetailFragment : Fragment() {

    lateinit var userEmail: String
    lateinit var universityName: String
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_user_detail, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setValues()
    }


    private fun setValues() {
        val args: UserDetailFragmentArgs? = arguments?.let {
            UserDetailFragmentArgs.fromBundle(it)
        }
        args?.let {
            userEmail = it.mail.toString()
            universityName = it.university.toString()
            tv_fragment_title.text = "User Email : $userEmail \n University : $universityName"
        }
    }


}