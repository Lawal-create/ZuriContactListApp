package com.example.contactlistapp.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import androidx.appcompat.app.AlertDialog
import androidx.core.widget.doOnTextChanged
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.contactlistapp.R
import com.example.contactlistapp.adapters.category_adapter
import com.example.contactlistapp.adapters.contact_adapter
import com.example.contactlistapp.data.contactDataManager
import com.example.contactlistapp.databinding.ActivityContactBinding
import com.example.contactlistapp.databinding.DialogueBoxBinding
import com.example.contactlistapp.datamodel.ContactList

private lateinit var binding: ActivityContactBinding
private lateinit var contactAdapter: contact_adapter


class ContactActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_contact)
        binding= ActivityContactBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val context=this@ContactActivity
        val index=intent.getIntExtra(INTEGER_INTENT_FROM_RECYCLER_VIEW,0)
        val categories= contactDataManager.getCategories(context)[index]
        contactAdapter=contact_adapter(context,categories)

        supportActionBar?.title = categories.name

        val decoration = DividerItemDecoration(context, LinearLayoutManager.VERTICAL)
        getDrawable(R.color.black)?.let { decoration.setDrawable(it) }

        binding.contactList.let{
            it.adapter= contactAdapter
            it.layoutManager=LinearLayoutManager(context)
            it.addItemDecoration(decoration)
        }

        binding.addContact.setOnClickListener {
            showDialogueBox()
        }
    }
    private fun showDialogueBox(){
        val builder = AlertDialog.Builder(this)
        val alertBinding = DialogueBoxBinding.inflate(layoutInflater,null,false)
        val view = this.layoutInflater.inflate(R.layout.dialogue_box,null)
        builder.setView(alertBinding.root)
        builder.setCancelable(false)
        val alertDialog = builder.create()
        alertDialog.window?.setBackgroundDrawable(getDrawable(android.R.color.transparent))
        alertDialog.setCanceledOnTouchOutside(true)
        alertDialog.show()

        alertBinding.editTextPhone.doOnTextChanged { text, start, before, count ->
            alertBinding.buttonAddContact.isEnabled = !(alertBinding.editTextName.text.toString().isEmpty() ||
                    text?.length!! <11)
        }

        alertBinding.editTextName.doOnTextChanged { text, start, before, count ->
            alertBinding.buttonAddContact.isEnabled = (text?.length!!>0 &&  alertBinding.editTextPhone.text!!.length>+11)
        }

        alertBinding.buttonAddContact.setOnClickListener {
            contactAdapter.addContact(
                ContactList(
                alertBinding.editTextName.text.toString(),
                alertBinding.editTextPhone.text.toString()
            )
            )

            alertDialog.dismiss()
        }

    }

    companion object{
        const val INTEGER_INTENT_FROM_RECYCLER_VIEW = "INDEX_OF_CATEGORY"
    }

}