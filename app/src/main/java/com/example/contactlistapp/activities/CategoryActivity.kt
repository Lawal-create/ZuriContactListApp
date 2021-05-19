package com.example.contactlistapp.activities

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.GridLayout
import androidx.recyclerview.widget.GridLayoutManager
import com.example.contactlistapp.R
import com.example.contactlistapp.adapters.category_adapter
import com.example.contactlistapp.data.contactDataManager
import com.example.contactlistapp.databinding.ActivityMainBinding

class CategoryActivity : AppCompatActivity() {
    lateinit var binding:ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        binding= ActivityMainBinding.inflate(layoutInflater)

        setContentView(binding.root);
        val context:Context=this@CategoryActivity

        binding.categoryLists.let {
            it.adapter=category_adapter(context,contactDataManager.getCategories(context))
            it.layoutManager=GridLayoutManager(context,2);

        }

    }
}