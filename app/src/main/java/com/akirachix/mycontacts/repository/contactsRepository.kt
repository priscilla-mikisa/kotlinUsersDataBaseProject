package com.akirachix.mycontacts.repository

import androidx.lifecycle.LiveData
import com.akirachix.mycontacts.model.ContactsApp
import com.akirachix.mycontacts.dataBase.ContactsDataBase
import com.akirachix.mycontacts.model.Contact
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class contactsRepository {
    val dataBase = ContactsDataBase.getDataBase(ContactsApp.appContext)
    val contactDao =  dataBase.getContactDao()

    suspend fun saveContact(contact: Contact){
        withContext(Dispatchers.IO){
            contactDao.insertContact(contact)

        }
    }

    fun getAllContacts():LiveData<List<Contact>>{
        return  contactDao.getAllContacts()
    }

    fun getContactById(contactId:Int):LiveData<Contact>{
        return  contactDao.getContactById(contactId)
    }
    suspend fun updateContact(contact: Contact){
        withContext(Dispatchers.IO){
            contactDao.updateContact(contact)
        }
    }
}