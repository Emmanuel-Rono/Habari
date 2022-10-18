package com.example.habari.newsRepository

import com.example.habari.api.RetrofitInstance

class NewsRepository(val db: NewsRepository) {
    suspend fun  getNews(countrycode:String, pagenumber:Int)=RetrofitInstance.api.getNews(countrycode,pagenumber)
}