package com.example.lembretes.main.contacts.view

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.RequestManager
import com.example.lembretes.databinding.ContactItemCardBinding
import com.example.lembretes.main.contacts.model.ContactModel

class ContactsAdapter(
    val glide: RequestManager,
    private var contacts: MutableList<ContactModel>
    ) : RecyclerView.Adapter<ContactsAdapter.ContactsViewHolder>() {

    private lateinit var binding: ContactItemCardBinding
    inner class ContactsViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val contactName = binding.contactItemTitleNameText
        var contactRelationship = binding.contactItemDescriptionText
        var contactImage = binding.contactItemImage
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ContactsViewHolder {
        binding = ContactItemCardBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ContactsViewHolder(binding.root)
    }

    override fun onBindViewHolder(holder: ContactsViewHolder, position: Int) {
        val currentItem = contacts[position]

        holder.contactName.text = currentItem.name
        holder.contactRelationship.text = currentItem.relationship

        glide.load(currentItem.contactImage).into(holder.contactImage)
    }

    override fun getItemCount() = contacts.size
}