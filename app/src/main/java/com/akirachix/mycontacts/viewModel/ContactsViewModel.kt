package com.akirachix.mycontacts.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.akirachix.mycontacts.model.Contact
import com.akirachix.mycontacts.repository.contactsRepository
import kotlinx.coroutines.launch

class ContactsViewModel: ViewModel() {
    val contactsRepo = contactsRepository()

    fun  saveContact(contact: Contact){
        viewModelScope.launch {
            contactsRepo.saveContact(contact)
        }
    }
    fun getAllContacts():LiveData<List<Contact>>{
        return  contactsRepo.getAllContacts()
    }

    fun getContactById(contactId:Int):LiveData<Contact>{
        return contactsRepo.getContactById(contactId)
    }
    fun updateContact(contact: Contact){
        viewModelScope.launch {
            contactsRepo.updateContact(contact)
        }
    }
}