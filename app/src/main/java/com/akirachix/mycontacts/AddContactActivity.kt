package com.akirachix.mycontacts

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.akirachix.mycontacts.databinding.ActivityAddContactBinding
import com.akirachix.mycontacts.model.Contact
import com.akirachix.mycontacts.viewModel.ContactsViewModel

class AddContactActivity : AppCompatActivity() {
    lateinit var binding: ActivityAddContactBinding
    val contactsViewModel: ContactsViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAddContactBinding.inflate(layoutInflater)
        setContentView(binding.root)

    }

    override fun onResume() {
        super.onResume()
        binding.btnSave.setOnClickListener {
            validateContact()
        }
    }

    fun validateContact() {
        val name = binding.eTName.text.toString()
        val phone = binding.eTPhone.text.toString()
        val email = binding.eTEmail.text.toString()
        var error = false

        if (name.isBlank()) {
            error = true
            binding.eTName.error = getString(R.string.name_is_required)
        }

        if (phone.isBlank()) {
            error = true
            binding.eTPhone.error = getString(R.string.phone_is_required)
        }

        if (email.isBlank()) {
            error = true
            binding.eTEmail.error = getString(R.string.email_required)
        }




        if (!error){

            val newContact = Contact(contactId = 0, name=name,email=email, phoneNumber = phone, avatar = "")
            contactsViewModel.saveContact(newContact)
        }



    }
}







