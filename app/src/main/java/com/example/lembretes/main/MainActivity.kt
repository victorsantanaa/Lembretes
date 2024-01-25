package com.example.lembretes.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.findNavController
import androidx.navigation.ui.NavigationUI
import com.example.lembretes.R
import com.example.lembretes.databinding.ActivityMainBinding
import com.example.lembretes.databinding.ActivityWelcomeBinding

class MainActivity : AppCompatActivity() {

    private val binding by lazy { ActivityMainBinding.inflate(layoutInflater) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
    }

    override fun onStart() {
        super.onStart()
        NavigationUI.setupWithNavController(
            binding.bottomNavigationView,
            findNavController(R.id.activity_main_default_nav_host)
        )
    }
}