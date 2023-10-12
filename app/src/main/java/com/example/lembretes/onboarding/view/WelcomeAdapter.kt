package com.example.lembretes.onboarding.view

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter

class WelcomeAdapter(
    private val fragmentManager: FragmentManager,
    private val lifecycle: Lifecycle,
    private val listFragments: ArrayList<Fragment>
) : FragmentStateAdapter(fragmentManager, lifecycle) {
    override fun getItemCount() = listFragments.size

    override fun createFragment(position: Int) = listFragments[position]
}