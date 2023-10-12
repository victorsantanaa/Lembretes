package com.example.lembretes.onboarding.view

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.lembretes.MainActivity
import com.example.lembretes.R
import com.example.lembretes.databinding.ActivityWelcomeBinding
import com.example.lembretes.databinding.FragmentSecondWelcomeBinding
import com.example.lembretes.onboarding.view.fragment.ALREADY_KEY
import com.example.lembretes.onboarding.view.fragment.FirstWelcomeFragment
import com.example.lembretes.onboarding.view.fragment.SecondWelcomeFragment
import com.example.lembretes.onboarding.view.fragment.WELCOME_FILE_KEY
import com.google.android.material.tabs.TabLayoutMediator

class WelcomeActivity : AppCompatActivity() {

    private val binding by lazy { ActivityWelcomeBinding.inflate(layoutInflater) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        if (isAlreadyWelcomed()) {
            val intent = Intent(this, MainActivity::class.java)
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
            startActivity(intent)
            finish()
        }

        val fragmentList = arrayListOf(FirstWelcomeFragment(), SecondWelcomeFragment())

        val viewPagerAdapter = WelcomeAdapter(supportFragmentManager, lifecycle, fragmentList)

        binding.activityWelcomeViewPager.adapter = viewPagerAdapter

        TabLayoutMediator(
            binding.activityWelcomeTabLayout,
            binding.activityWelcomeViewPager
        ) { _, _ -> }.attach()

    }

    private fun isAlreadyWelcomed(): Boolean {
        val sharedPreferences = getSharedPreferences(WELCOME_FILE_KEY, Context.MODE_PRIVATE)
        return sharedPreferences.getBoolean(ALREADY_KEY, false)

    }
}