package com.route.islamic41.ui.chapterDetails

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.route.islamic41.databinding.ActivityChapterDetailsBinding

class ChapterDetailsActivity : AppCompatActivity() {
    var chapterPosition: Int = -1
    lateinit var chapterTitle: String
    lateinit var binding: ActivityChapterDetailsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //   setContentView(R.layout.activity_chapter_details)

        binding = ActivityChapterDetailsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding
        initParams()
        initViews()
        readChapter()
    }

    private fun readChapter() {
        val allfileContent =
            assets
                .open("${chapterPosition + 1}.txt")
                .bufferedReader()
                .use { it.readText() }
        val versesList = allfileContent.split("\n")
        bindVersesToRecyclerViewAdapter(versesList)
    }

    private fun bindVersesToRecyclerViewAdapter(versesList: List<String>) {
        val versesAdapter = VersesAdapter(versesList)
        binding.content.versesRecycler.adapter = versesAdapter
    }

    private fun initViews() {
        // to show back button
        setSupportActionBar(binding.toolBar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setDisplayShowHomeEnabled(true)
        title = null
        binding.chapterTitle.text = chapterTitle
    }

    override fun onSupportNavigateUp(): Boolean {
        finish()
        return true
    }

    private fun initParams() {
        chapterPosition = intent.getIntExtra(EXTRA_POSITION, -1)
        chapterTitle = intent.getStringExtra(EXTRA_TITLE) ?: ""
    }

    companion object {
        // static
        const val EXTRA_TITLE = "title"
        const val EXTRA_POSITION = "position"
    }
}
