package com.example.cracktracker

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.drawerlayout.widget.DrawerLayout
import androidx.core.view.GravityCompat
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.floatingactionbutton.FloatingActionButton
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.NavigationUI
import androidx.fragment.app.FragmentTransaction

class MainActivity : AppCompatActivity() {
    private lateinit var drawerLayout: DrawerLayout
    private lateinit var bottomNav: BottomNavigationView
    private lateinit var fab: FloatingActionButton

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Initialize views
        drawerLayout = findViewById(R.id.drawer_layout)
        bottomNav = findViewById(R.id.bottom_nav)
        fab = findViewById(R.id.fab_center)  // Initialize FloatingActionButton

        // Disable swipe gesture for opening the drawer
        drawerLayout.setDrawerLockMode(DrawerLayout.LOCK_MODE_LOCKED_CLOSED)

        // Set up the NavController for navigation
        val navHostFragment = supportFragmentManager.findFragmentById(R.id.nav_host_fragment) as NavHostFragment
        val navController = navHostFragment.navController

        // Set up BottomNavigationView with NavController
        NavigationUI.setupWithNavController(bottomNav, navController)

        // Show/hide BottomNavigationView based on the current fragment
        navController.addOnDestinationChangedListener { _, destination, _ ->
            when (destination.id) {
                R.id.homeFragment, R.id.user_settings -> {
                    bottomNav.visibility = View.VISIBLE
                    fab.visibility = View.VISIBLE // Show FAB on homeFragment and user_settings
                }
                else -> {
                    bottomNav.visibility = View.GONE
                    fab.visibility = View.GONE // Hide FAB on other fragments
                }
            }
        }

        // Manually switch between HomeFragment and user_settings using BottomNavigationView
        bottomNav.setOnNavigationItemSelectedListener { item ->
            when (item.itemId) {
                R.id.nav_home -> {
                    // Replace the current fragment with HomeFragment
                    val homeFragment = FragmentHome()
                    val transaction: FragmentTransaction = supportFragmentManager.beginTransaction()
                    transaction.replace(R.id.nav_host_fragment, homeFragment)
                    transaction.addToBackStack(null)
                    transaction.commit()
                    return@setOnNavigationItemSelectedListener true
                }
                R.id.nav_settings -> {
                    // Replace the current fragment with user_settings
                    val settingsFragment = SettingsFragment()
                    val transaction: FragmentTransaction = supportFragmentManager.beginTransaction()
                    transaction.replace(R.id.nav_host_fragment, settingsFragment)
                    transaction.addToBackStack(null)
                    transaction.commit()
                    return@setOnNavigationItemSelectedListener true
                }
                else -> false
            }
        }
    }

    // Function to open the drawer from fragments
    fun openDrawer() {
        drawerLayout.setDrawerLockMode(DrawerLayout.LOCK_MODE_UNLOCKED) // Temporarily unlock
        drawerLayout.openDrawer(GravityCompat.START)
    }
}
