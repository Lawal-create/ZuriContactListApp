package com.example.contactlistapp.adapters

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.example.contactlistapp.activities.ContactActivity
import com.example.contactlistapp.databinding.CategoryListItemBinding
import com.example.contactlistapp.datamodel.Category
import com.example.contactlistapp.datamodel.ContactList

class category_adapter(val context:Context, val contactList:List<Category>):RecyclerView.Adapter<category_adapter.CategoryViewholder>() {

    class CategoryViewholder(val binding: CategoryListItemBinding):RecyclerView.ViewHolder(binding.root){
        fun bind(context: Context, category: Category){
            binding.backgroundColor.setBackgroundColor(ContextCompat.getColor(context,category.color))
            binding.bigLetter.text=category.name.substring(0,1);
            binding.letterWord.text=category.name
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategoryViewholder {
        val binding=CategoryListItemBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return CategoryViewholder(binding)
    }

    override fun getItemCount(): Int {
        return contactList.size
    }

    override fun onBindViewHolder(holder: CategoryViewholder, position: Int) {
        holder.bind(context,contactList[position])
        holder.binding.backgroundColor.setOnClickListener{
            val intent = Intent(context, ContactActivity::class.java)
            intent.putExtra(ContactActivity.INTEGER_INTENT_FROM_RECYCLER_VIEW,position)
            context.startActivity(intent)
        }


    }
}