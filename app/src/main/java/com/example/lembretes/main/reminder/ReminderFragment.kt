package com.example.lembretes.main.reminder

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.lembretes.R
import com.example.lembretes.ReminderMainActivity
import com.example.lembretes.databinding.FragmentContactsBinding
import com.example.lembretes.databinding.FragmentReminderBinding

class ReminderFragment : Fragment() {

    private lateinit var binding: FragmentReminderBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentReminderBinding.inflate(inflater, container, false)

        binding.fragmentReminderAddEventButton.setOnClickListener {
            openAddReminderActivity()
        }

        return binding.root
    }

    private fun openAddReminderActivity() {
        val intent = Intent(this.activity, ReminderMainActivity::class.java)
        startActivity(intent)
    }
}
