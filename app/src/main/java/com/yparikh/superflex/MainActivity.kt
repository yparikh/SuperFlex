package com.yparikh.superflex

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupWithNavController
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.yparikh.superflex.ui.main.MainFragment

class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_activity)
        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.container, MainFragment.newInstance())
                .commitNow()
        }
        val navHostFragment =
            supportFragmentManager.findFragmentById(R.id.nav_host_fragment) as NavHostFragment
        val navController = navHostFragment.navController
        findViewById<BottomNavigationView>(R.id.bottomNavigationView)
            .setupWithNavController(navController)

        navController.addOnDestinationChangedListener
        { _, destination, _ ->
            when (destination.id) {
                R.id.A_Fragment -> {
                    // Add your requirement here base with destination
                }
                else -> {
                    // Add your requirement here
                }
            }

            // Manage bottom nav visibility and etc
            if (destination.id in arrayOf(
                    R.id.A_Fragment,
                    R.id.B_Fragment,
                    R.id.C_Fragment
                )) {
                navView.visibility = View.VISIBLE
                this.supportActionBar?.show()
                setupToolbar()
            }
            else {
                navView.visibility = View.GONE
                this.supportActionBar?.hide()
                // No Toolbar

            }
        }

    }




}