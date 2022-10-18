package com.example.habari

import androidx.fragment.app.Fragment
import com.example.habari.db.articleDatabase
import com.example.habari.db.newsViewmodel
import com.example.habari.newsRepository.NewsRepository
import com.example.habari.ui.newsViewModelProviderFactory

lateinit var newsViewModel:newsViewmodel
class BreakingNews : Fragment(R.layout.fragment_breaking__news)

{
    //Instantiate the newsRepository
    val newsrepository =NewsRepository((articleDatabase(this)))

    val newsviewModelFactory:newsViewModelProviderFactory(newsrepository)




}

