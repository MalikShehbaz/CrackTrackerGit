package com.example.cracktracker

import android.content.Intent
import android.content.pm.PackageManager
import android.os.Bundle
import android.provider.MediaStore
import android.view.View
import android.widget.ImageView
import android.widget.Toast
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import androidx.fragment.app.Fragment

class FragmentHome : Fragment(R.layout.fragment_home) {
    private var drawerLayout: DrawerLayout? = null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val menuButton = view.findViewById<ImageView>(R.id.menuButton)
        val addButton = view.findViewById<ImageView>(R.id.btn_add) // Plus button
        drawerLayout = activity?.findViewById(R.id.drawer_layout)

        // Open drawer when menu button is clicked
        menuButton?.setOnClickListener {
            drawerLayout?.openDrawer(GravityCompat.START)
        }

        // Open camera only if a camera app is available
        addButton?.setOnClickListener {
            val cameraIntent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
            val packageManager = activity?.packageManager

            if (cameraIntent.resolveActivity(packageManager!!) != null) {
                startActivity(cameraIntent)
            } else {
                Toast.makeText(requireContext(), "No camera app found!", Toast.LENGTH_SHORT).show()
            }
        }
    }

    override fun onResume() {
        super.onResume()
        // Completely disable drawer swipe gesture
        drawerLayout?.setDrawerLockMode(DrawerLayout.LOCK_MODE_LOCKED_CLOSED)
    }
}
