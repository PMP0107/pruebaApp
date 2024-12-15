package com.example.final_entregau3_pmdm.projects

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.final_entregau3_pmdm.R
import com.example.final_entregau3_pmdm.data.entities.ProjectEntity

class ProjectAdapter(private var list: List<ProjectEntity>,
                     private  val onClickListener:(ProjectEntity) -> Unit,
                     private  val onDeleteClickListener:(ProjectEntity) -> Unit): RecyclerView.Adapter<ProjectsViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProjectsViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return ProjectsViewHolder(layoutInflater.inflate(R.layout.item_project, parent, false))
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: ProjectsViewHolder, position: Int) {
        val item = list[position]
        holder.render(item, onClickListener, onDeleteClickListener)
    }

    fun submitList(projectList: MutableList<ProjectEntity>) {
        this.list = projectList
    }
}