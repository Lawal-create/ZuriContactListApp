package com.example.contactlistapp.datamodel


class Category(val name:String, val color:Int)
{
    private lateinit var contacts:MutableList<ContactList>
    private fun getAllContacts():MutableList<ContactList>
    {
        if(!(this::contacts.isInitialized))
        {
            contacts = mutableListOf()
        }

        return contacts
    }

    fun addContact(contact: ContactList)
    {
        getAllContacts().add(contact)
    }

    fun getContactList(): MutableList<ContactList>
    {
        return getAllContacts()
    }
}