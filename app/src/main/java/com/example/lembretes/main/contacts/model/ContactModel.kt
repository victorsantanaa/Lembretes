package com.example.lembretes.main.contacts.model

data class ContactModel(
    val id: Int,
    val name: String,
    val relationship: String,
    val phoneNumber: String,
    val instagram: String? = null,
    val facebook: String? = null,
    val email: String? = null,
    val contactImage: String? = null
)
