package com.example.habari.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.habari.db.newsViewmodel
import com.example.habari.newsRepository.NewsRepository

class newsViewModelProviderFactory(val newsRepo:NewsRepository) :ViewModelProvider.Factory
{

    override fun <T : ViewModel> create(modelClass: Class<T>): T
    {
        return newsViewmodel(newsRepo) as T
    }
}

