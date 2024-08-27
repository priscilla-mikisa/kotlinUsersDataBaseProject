package com.akirachix.mycontacts.ui

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import com.akirachix.mycontacts.R
import com.akirachix.mycontacts.databinding.ActivityAddContactBinding
import com.akirachix.mycontacts.model.Contact
import com.akirachix.mycontacts.databinding.ContactListItemBinding
import com.akirachix.mycontacts.viewModel.ContactsViewModel

class ContactsAdapter(var contactsList: List<Contact>, val context: Context):
    RecyclerView.Adapter<ContactsViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ContactsViewHolder {
       val binding = ContactListItemBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return  ContactsViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ContactsViewHolder, position: Int) {
       val contact = contactsList[position]
        holder.binding.tvName.text = contact.name
        holder.binding.tvPhoneNumber.text = contact.phoneNumber
        holder.binding.tvEmail.text = contact.email
        holder.binding.cvContacts.setOnClickListener {
            val  intent = Intent(context, ViewContactActivity::class.java)
            intent.putExtra("Contact_Id", contact.contactId)
            context.startActivity(intent)
        }
    }

    override fun getItemCount(): Int {
        return contactsList.size

    }
}

class ContactsViewHolder(var binding: ContactListItemBinding): RecyclerView.ViewHolder(binding.root)
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

            val newContact =
                Contact(contactId = 0, name = name, email = email, phoneNumber = phone, avatar = "")
            contactsViewModel.saveContact(newContact)
        }



    }
}