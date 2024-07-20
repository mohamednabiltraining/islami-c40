package com.route.islamic41.ui.home.quran

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.Adapter
import com.route.islamic41.R

class ChaptersRecyclerAdapter(
    private val chapters: List<String>,
) : Adapter<ChaptersRecyclerAdapter.ViewHolder>() {
    var onItemClickListener: OnItemClickListener? = null

    class ViewHolder(
        itemView: View,
    ) : RecyclerView.ViewHolder(itemView) {
        val title: TextView = itemView.findViewById(R.id.chapter_title)
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int,
    ): ViewHolder {
        val view =
            LayoutInflater
                .from(parent.context)
                .inflate(R.layout.item_chapter, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int = chapters.size

    override fun onBindViewHolder(
        holder: ViewHolder,
        position: Int,
    ) {
        val title = chapters[position]
        holder.title.setText(title)
        if (onItemClickListener != null) {
            holder.itemView.setOnClickListener {
                onItemClickListener?.onItemClick(position, title)
            }
        }
    }

    fun interface OnItemClickListener {
        fun onItemClick(
            position: Int,
            title: String,
        )
    }
}
