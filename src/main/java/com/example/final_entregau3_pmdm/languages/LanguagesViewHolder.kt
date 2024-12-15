package com.example.final_entregau3_pmdm.languages

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.example.final_entregau3_pmdm.data.entities.LanguageEntity
import com.example.final_entregau3_pmdm.databinding.ItemLanguageBinding

class LanguagesViewHolder(view: View):
    RecyclerView.ViewHolder(view){


    val binding = ItemLanguageBinding.bind(view)
    private lateinit var languages: LanguageEntity

    fun render(item: LanguageEntity){
        languages = item
        binding.tvLangName.text = item.name
    }

}