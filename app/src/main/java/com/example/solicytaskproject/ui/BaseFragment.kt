package com.example.solicytaskproject.ui

import android.os.Bundle
import android.view.Gravity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.NavHost
import androidx.navigation.ui.setupWithNavController
import com.example.solicytaskproject.R
import com.example.solicytaskproject.databinding.FragmentBaseBinding
import com.google.android.material.navigation.NavigationView

class BaseFragment : Fragment() {
    private lateinit var binding:FragmentBaseBinding
    private lateinit var navController: NavController
    private lateinit var navHost: NavHost
    private lateinit var drawerLayout: DrawerLayout

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentBaseBinding.inflate(inflater,container,false)

        drawerLayout = binding.drawerLayout
        val navView: NavigationView = binding.homeNavView

        navHost = childFragmentManager.findFragmentById(R.id.home_container) as NavHost
        navController = navHost.navController
        navView.setupWithNavController(navController)


        // Inflate the layout for this fragment
        return binding.root
    }

    fun openDrawer(){
        drawerLayout.openDrawer(GravityCompat.START)
    }

}

