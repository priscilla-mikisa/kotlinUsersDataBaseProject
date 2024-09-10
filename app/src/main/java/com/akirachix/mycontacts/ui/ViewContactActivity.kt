package com.akirachix.mycontacts.ui

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.activity.result.PickVisualMediaRequest
import androidx.activity.result.contract.ActivityResultContracts
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.akirachix.mycontacts.R
import com.akirachix.mycontacts.databinding.ActivityMainBinding
import com.akirachix.mycontacts.databinding.ActivityViewContactBinding
import com.akirachix.mycontacts.model.Contact
import com.akirachix.mycontacts.repository.contactsRepository
import com.akirachix.mycontacts.viewModel.ContactsViewModel

class ViewContactActivity : AppCompatActivity() {
    lateinit var binding: ActivityViewContactBinding
    var contactId = 0
    val contactsViewModel: ContactsViewModel by viewModels()
    lateinit var mycontact:Contact

    val pickMedia = registerForActivityResult(ActivityResultContracts.PickVisualMedia()){ uri ->
        if (uri != null) {
            mycontact.avatar = uri.path.toString()
            contactsViewModel.updateContact(mycontact)
        }
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityViewContactBinding.inflate(layoutInflater)
        setContentView(binding.root)

        if (intent.extras!=null){
            contactId = intent.getIntExtra("Contact_Id", 0)
        }
        else{
            finish()
        }

    }

    override fun onResume() {
        super.onResume()
        contactsViewModel.getContactById(contactId).observe(this){contact ->
            mycontact = contact
            binding.tvContactsName.text = contact.name
            binding.tvContactPhone.text = contact.phoneNumber
            binding.tvContactEmail.text = contact.email
              }
        binding.ivContactImage.setOnClickListener{
            pickMedia.launch(PickVisualMediaRequest(ActivityResultContracts.PickVisualMedia.ImageOnly))
        }
    }
}