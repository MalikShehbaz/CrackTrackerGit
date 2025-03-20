package com.example.cracktracker

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController

class AccountFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_account, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Find buttons
        val createAccountButton = view.findViewById<Button>(R.id.createAccountButton)
        val goToHomeButton = view.findViewById<Button>(R.id.goToHomeButton)

        // Navigate to SignUpFragment when "Create Account" button is clicked
        createAccountButton.setOnClickListener {
            findNavController().navigate(R.id.action_accountFragment_to_signupFragment)
        }

        // Navigate to HomeFragment when "Go Home" button is clicked
        goToHomeButton.setOnClickListener {
            findNavController().navigate(R.id.action_accountFragment_to_homeFragment2)
        }
    }
}
