package com.example.habari.db

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.bumptech.glide.load.engine.Resource
import com.example.habari.NewsResponse
import com.example.habari.newsRepository.NewsRepository

class newsViewmodel (val newsRepository: NewsRepository):ViewModel()
{
val livedata :MutableLiveData<Resource<NewsResponse>>
}

