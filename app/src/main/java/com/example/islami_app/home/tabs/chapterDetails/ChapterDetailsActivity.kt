package com.example.islami_app.home.tabs.chapterDetails

import android.os.Build
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.islami_app.databinding.ActivityChapterDetailsBinding
import com.example.islami_app.home.tabs.AppContacts
import com.example.islami_app.model.Chapter

class ChapterDetailsActivity : AppCompatActivity() {

    private lateinit var viewBinding: ActivityChapterDetailsBinding
    private var chapter: Chapter? = null

    private lateinit var versesList: List<String>
    private lateinit var adapter: VersesAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        viewBinding = ActivityChapterDetailsBinding.inflate(layoutInflater)
        setContentView(viewBinding.root)

        init()
    }

    private fun init() {
        // Get chapter from intent
        chapter = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
            intent.getParcelableExtra(
                AppContacts.EXTRA.EXTRA_CHAPTER,
                Chapter::class.java
            )
        } else {
            @Suppress("DEPRECATION")
            intent.getParcelableExtra(AppContacts.EXTRA.EXTRA_CHAPTER)
        }

        // Toolbar & titles
        viewBinding.toolbar.toolbarTitle.text = chapter?.titleEn
        viewBinding.content.chapterTitleAr.text = chapter?.titleAr

        // Read verses first
        readChapterDetails(chapter!!.index)

        // Then init RecyclerView
        initRecyclerView()
    }

    private fun initRecyclerView() {
        adapter = VersesAdapter(versesList)
        viewBinding.content.versesRecycler.layoutManager =
            LinearLayoutManager(this)
        viewBinding.content.versesRecycler.adapter = adapter
    }

    private fun readChapterDetails(chapterIndex: Int) {
        val fileIndex = chapterIndex + 1

        try {
            val content = assets
                .open("quran/$fileIndex.txt")
                .bufferedReader()
                .use { it.readText() }

            versesList = content.split("\n")

        } catch (e: Exception) {
            e.printStackTrace()
            versesList = emptyList()
        }
    }
}
