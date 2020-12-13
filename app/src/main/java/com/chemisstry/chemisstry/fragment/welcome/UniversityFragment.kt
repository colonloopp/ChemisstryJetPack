package com.chemisstry.chemisstry.fragment.welcome

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import com.chemisstry.chemisstry.R
import kotlinx.android.synthetic.main.fragment_university.*


class UniversityFragment : Fragment() {

    lateinit var userEmail: String
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_university, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setUpListeners()
        setValues()
    }

    private fun setUpListeners() {
        btn_fragment_user_detail?.setOnClickListener {
            val direction = UniversityFragmentDirections.universityToUserDetail()
            direction.mail = userEmail
            direction.university = "Chennai University"
            Navigation.findNavController(btn_fragment_user_detail).navigate(direction)
        }


    }

    private fun setValues() {
        val args: UniversityFragmentArgs? = arguments?.let {
            UniversityFragmentArgs.fromBundle(it)
        }
        args?.let {
            userEmail = it.mail.toString()
            tv_fragment_title.text = "User Email : $userEmail"
        }
    }


}