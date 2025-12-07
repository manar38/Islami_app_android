package com.example.islami_app.home.tabs.quran

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.viewbinding.ViewBindings
import com.example.islami_app.databinding.ItemChapterBinding
import com.example.islami_app.model.Chapter

class ChaptersAdapter(val chapters:List<Chapter>): RecyclerView.Adapter<ChaptersAdapter.ViewHolder>() {
     override fun onCreateViewHolder(
         parent: ViewGroup,
         viewType: Int
     ): ViewHolder {
         val itemBinding= ItemChapterBinding.inflate(
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
         val chapter = chapters[position]
         holder.itemBinding.englishTitleTv.text=chapter.titleEn
         holder.itemBinding.arabicTitleTv.text=chapter.titleAr
         holder.itemBinding.versesNumberTv.text=chapter.ayaNum
         holder.itemBinding.chapterIndexTv.text="${chapter.index+1}"
     }

     override fun getItemCount(): Int {
         return chapters.size
     }

     class ViewHolder(val itemBinding: ItemChapterBinding)
        :RecyclerView.ViewHolder(itemBinding.root){

    }
}