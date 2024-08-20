package com.akirachix.mycontacts.repository

import androidx.lifecycle.LiveData
import com.akirachix.mycontacts.model.ContactsApp
import com.akirachix.mycontacts.dataBase.ContactsDataBase
import com.akirachix.mycontacts.model.Contact
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class contactsRepository {
    val dataBase = ContactsDataBase.getDataBase(ContactsApp.appContext)

    suspend fun saveContact(contact: Contact){
        withContext(Dispatchers.IO){
            dataBase.getContactDao().insertContact(contact)
        }
    }

    fun getAllContacts():LiveData<List<Contact>>{
        return  dataBase.getContactDao().getAllContacts()
    }
}