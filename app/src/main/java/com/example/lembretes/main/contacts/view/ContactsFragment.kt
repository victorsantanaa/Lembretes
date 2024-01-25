package com.example.lembretes.main.contacts.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DividerItemDecoration
import com.bumptech.glide.Glide
import com.example.lembretes.R
import com.example.lembretes.databinding.FragmentContactsBinding
import com.example.lembretes.databinding.FragmentSecondWelcomeBinding
import com.example.lembretes.main.contacts.model.ContactModel

class ContactsFragment : Fragment() {

    private lateinit var binding : FragmentContactsBinding
    private lateinit var adapter: ContactsAdapter
    private var contacts: MutableList<ContactModel> = mutableListOf(
        ContactModel(
            0,
            "Joana",
            "Prima",
            "985402050",
        )
    )
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = FragmentContactsBinding.inflate(inflater, container, false)

        adapter = ContactsAdapter(Glide.with(this), contacts)
        binding.fragmentContactsRecyclerView.adapter = adapter
        binding.fragmentContactsRecyclerView.addItemDecoration(DividerItemDecoration(activity, DividerItemDecoration.VERTICAL))


        return binding.root
    }
}