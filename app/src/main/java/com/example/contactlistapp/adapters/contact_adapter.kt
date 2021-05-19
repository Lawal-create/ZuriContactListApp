package com.example.contactlistapp.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.contactlistapp.databinding.ContactListItemBinding
import com.example.contactlistapp.datamodel.Category
import com.example.contactlistapp.datamodel.ContactList

class contact_adapter(private val context: Context, private val category:Category ):RecyclerView.Adapter<contact_adapter.ContactViewHolder>() {
    class ContactViewHolder(private val binding: ContactListItemBinding):RecyclerView.ViewHolder(binding.root) {

        fun bind(contact:ContactList){
            binding.contactName.text=contact.name
            binding.contactNumber.text=contact.number
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ContactViewHolder {
        val binding=ContactListItemBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return ContactViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return category.getContactList().size
    }

    override fun onBindViewHolder(holder: ContactViewHolder, position: Int) {
        holder.bind(category.getContactList()[position])

    }
    fun addContact(contact:ContactList){
        category.addContact(contact)
        notifyItemInserted(itemCount-1)
    }

}