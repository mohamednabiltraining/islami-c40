package com.route.islamic41.ui.home.hadeth

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.route.islamic41.databinding.ItemHadethBinding

class HadethListAdapter(
    val hadethList: List<Hadeth>,
) : RecyclerView.Adapter<HadethListAdapter.ViewHolder>() {
    class ViewHolder(
        val binding: ItemHadethBinding,
    ) : RecyclerView.ViewHolder(binding.root)

    override fun getItemCount(): Int = hadethList.size

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int,
    ): ViewHolder {
        val binding =
            ItemHadethBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false,
            )
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(
        holder: ViewHolder,
        position: Int,
    ) {
        holder.binding.chapterTitle.text = hadethList[position].title
    }
}
