package com.example.contactlistapp.data

import android.content.Context
import com.example.contactlistapp.datamodel.Category

object contactDataManager {
    private lateinit var context:Context
    private lateinit var allCategories:MutableList<Category>

    fun getCategories(context: Context):List<Category>{
        if(!this::allCategories.isInitialized){
            allCategories= mutableListOf(
                Category("Family",android.R.color.darker_gray),
                Category("Friend",android.R.color.holo_blue_bright),
                Category("Colleagues",android.R.color.holo_green_light),
                Category("Tutors",android.R.color.holo_orange_light),
                Category("Zuri Training",android.R.color.holo_purple)

            )
        }

        return allCategories
    }

}