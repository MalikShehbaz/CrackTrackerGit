package com.example.cracktracker

import android.os.Bundle
import android.view.View
import android.widget.ImageView
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import androidx.fragment.app.Fragment

class FragmentHome : Fragment(R.layout.fragment_home) {

    private var drawerLayout: DrawerLayout? = null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val menuButton = view.findViewById<ImageView>(R.id.menuButton)
        drawerLayout = activity?.findViewById(R.id.drawer_layout)

        menuButton?.setOnClickListener {
            drawerLayout?.openDrawer(GravityCompat.START)
        }
    }

    override fun onResume() {
        super.onResume()
        drawerLayout?.setDrawerLockMode(DrawerLayout.LOCK_MODE_LOCKED_CLOSED)
    }
}
