package com.chemisstry.chemisstry.fragment.welcome

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import com.chemisstry.chemisstry.R
import kotlinx.android.synthetic.main.fragment_user_email.*


class UserEmailFragment : Fragment() {

    lateinit var userEmail: String
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_user_email, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setUpListeners()
    }

    private fun setUpListeners() {
        btn_fragment_university?.setOnClickListener {
            val direction = UserEmailFragmentDirections.userEmailToUniversity()
            direction.mail = "user@email.com"
            Navigation.findNavController(btn_fragment_university).navigate(direction)
        }


    }


}