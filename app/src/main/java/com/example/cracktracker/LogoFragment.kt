package com.example.cracktracker

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import android.widget.Button
import androidx.navigation.fragment.findNavController

class LogoFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the XML layout for this fragment
        val view = inflater.inflate(R.layout.fragment_logo, container, false)

        // Find the "Get Started" button
        val getStartedButton = view.findViewById<Button>(R.id.getStartedButton)

        // Set a click listener on the button
        getStartedButton.setOnClickListener {
            // Navigate to SecondFragment
            findNavController().navigate(R.id.action_logoFragment_to_accountFragment)
        }

        return view
    }
}
