package com.akirachix.mycontacts.ui

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.akirachix.mycontacts.AddContactActivity
import com.akirachix.mycontacts.databinding.ActivityMainBinding
import com.akirachix.mycontacts.model.Contact

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.rvContacts.layoutManager = LinearLayoutManager(this)
        displayContacts()

    }

    override fun onResume() {
        super.onResume()
        binding.floatingActionButton.setOnClickListener { startActivity((Intent(this,  AddContactActivity::class.java))) }
    }
    fun displayContacts(){
//        val contact1 = Contact("Anna","0741817334","anna@gmail.com","")
//        val contact2 = Contact("Mike","0700000000","anna@gmail.com","")
//        val contact3 = Contact("Santos","0740000034","anna@gmail.com","")
//        val contact4 = Contact("Dennis","0748888834","anna@gmail.com","")
//        val contact5 = Contact("Arielle","07090980334","anna@gmail.com","")
//        val contact6 = Contact("Simon","07418097708","anna@gmail.com","")
//        val contact7 = Contact("Priscilla","074086868698","anna@gmail.com","")
//        val contact8 = Contact("Cain","07418108768","anna@gmail.com","")
//        val contact9 = Contact("Abel","07418189070","anna@gmail.com","")
//
//        val contactList = listOf(contact1,contact2,contact3,contact4,contact5,contact6,contact7,contact8,contact9)
//        val  contactsAdapter = ContactsAdapter(contactList)
//        binding.rvContacts.adapter = contactsAdapter


    }
}