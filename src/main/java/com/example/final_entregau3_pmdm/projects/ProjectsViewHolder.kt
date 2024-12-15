package com.example.final_entregau3_pmdm.projects

import android.content.DialogInterface.OnClickListener
import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.example.final_entregau3_pmdm.data.entities.ProjectEntity
import com.example.final_entregau3_pmdm.databinding.ItemProjectBinding

class ProjectsViewHolder (view: View): RecyclerView.ViewHolder(view) {
    val binding = ItemProjectBinding.bind(view)

    fun render(project: ProjectEntity, onClickListener:(ProjectEntity) ->Unit, onDeleteClickListener: (ProjectEntity) -> Unit) {
        binding.tvTitle.text = project.name
        binding.tvDate.text = project.initDate
        binding.tvHours.text = project.duration.toString()
        binding.tvDescrip.text = project.description
        binding.tvPriori.text = project.priority
        itemView.setOnClickListener{
            onClickListener(project)
        }
        binding.btnDelete.setOnClickListener{
            onDeleteClickListener(project)
        }
    }
}