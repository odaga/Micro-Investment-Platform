package com.miroinvest.testproject

import android.annotation.SuppressLint
import android.content.pm.ActivityInfo.SCREEN_ORIENTATION_PORTRAIT
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.core.view.isVisible
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.NavigationUI
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.miroinvest.testproject.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var bottomNavigationView: BottomNavigationView
    private lateinit var navHostFragment: NavHostFragment
    private lateinit var navController: NavController


    @SuppressLint("SourceLockedOrientationActivity")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)

        requestedOrientation = SCREEN_ORIENTATION_PORTRAIT
        setContentView(binding.root)

        bottomNavigationView = findViewById(R.id.bottom_navigation_view)
        navHostFragment =
            supportFragmentManager.findFragmentById(R.id.nav_host_fragment) as NavHostFragment
        navController = navHostFragment.navController

        NavigationUI.setupWithNavController(
            bottomNavigationView, navController
        )

        bottomNavigationView.setOnNavigationItemSelectedListener { item ->
            when (item.itemId) {
                R.id.home_fragment -> {
                    navController.navigate(R.id.homeFragment)
                    true
                }

                R.id.portfolio_fragment -> {
                    navController.navigate(R.id.portFolioFragment)
//                    navController.navigate(R.id.withdrawFragment)
//                    navController.navigate(R.id.investmentFragment)
                    true
                }

                R.id.profile_fragment -> {
                    navController.navigate(R.id.profileFragment)
                    true
                }

                else -> false
            }
        }
        navController.addOnDestinationChangedListener(listener)
    }


    override fun onResume() {
        super.onResume()
        navController.addOnDestinationChangedListener(listener)
    }

    override fun onPause() {
        super.onPause()
        navController.addOnDestinationChangedListener(listener)
    }

    private val listener = NavController.OnDestinationChangedListener { _, destination, _ ->

        when (destination.id) {
            R.id.homeFragment -> {
                binding.bottomNavigationView.isVisible = true
            }

            R.id.portFolioFragment -> {
                binding.bottomNavigationView.isVisible = true
            }

            R.id.profileFragment -> {
                binding.bottomNavigationView.isVisible = true
            }

            else -> binding.bottomNavigationView.isVisible = false

        }
    }
}