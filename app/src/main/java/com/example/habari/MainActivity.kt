package com.example.habari

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupWithNavController
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {

    private lateinit var navcontroller:NavController
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
         //Setting up the navHost Fragment
        val navHost=supportFragmentManager.findFragmentById(R.id.fragment_container) as NavHostFragment
        navcontroller=navHost.navController

         //setting up the bottomNavigation
        val navigationbar=findViewById<BottomNavigationView>(R.id.bottomNavigation)
        navigationbar.setupWithNavController(navcontroller)

    }
}