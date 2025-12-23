package com.example.islami_app.home.tabs.hadith

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.islami_app.databinding.ItemHadethBinding
import com.example.islami_app.model.Hadeth


class HadethCaroselAdapter (val hadethList: List<Hadeth>) : RecyclerView.Adapter<HadethCaroselAdapter.ViewHolder>() {
    class ViewHolder(val viewBinding: ItemHadethBinding): RecyclerView.ViewHolder(viewBinding.root) {
        fun bind (hadeth: Hadeth){
            viewBinding.title.text=hadeth.title
            viewBinding.title.text=hadeth.content
        }
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ViewHolder {
        val itemBinding= ItemHadethBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return ViewHolder(itemBinding)

    }

    override fun onBindViewHolder(
        holder: ViewHolder,
        position: Int
    ) {
        val hadeth= hadethList[position]
        holder.bind(hadeth)

    }

    override fun getItemCount(): Int=hadethList.size
}