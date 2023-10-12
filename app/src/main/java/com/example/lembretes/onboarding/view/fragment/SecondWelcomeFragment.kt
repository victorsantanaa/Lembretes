package com.example.lembretes.onboarding.view.fragment

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.lembretes.MainActivity
import com.example.lembretes.R
import com.example.lembretes.databinding.FragmentSecondWelcomeBinding

const val WELCOME_FILE_KEY = "welcome_key"
const val ALREADY_KEY = "already_key"

class SecondWelcomeFragment : Fragment() {

    private lateinit var binding : FragmentSecondWelcomeBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentSecondWelcomeBinding.inflate(inflater, container, false)

        binding.activitySecondWelcomeButton.setOnClickListener {
            val intent = Intent(context, MainActivity::class.java)
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
            startActivity(intent)
            saveWelcomed()
            activity?.finish()
        }
            return binding.root
    }

    private fun saveWelcomed() {
        val editor = activity?.getSharedPreferences(WELCOME_FILE_KEY, Context.MODE_PRIVATE)?.edit()
        editor?.putBoolean(ALREADY_KEY, true)
        editor?.apply()
    }
}