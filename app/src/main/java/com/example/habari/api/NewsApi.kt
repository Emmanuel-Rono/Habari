package com.example.habari.api

import com.example.habari.NewsResponse
import com.example.habari.util.constants.Companion.API_KEY
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

//We wan to get breaking news from newsApi
//This is a get request thus we annotate thiswith @get
interface  NewsApi
{
    @GET("v1/articles")
    suspend fun getNews(
        @Query ("country")
        countrycode:String="ke",
    @Query("page")
    pagenumber:Int=1,
        @Query("apiKey")
        apiKey: String=API_KEY
    ): Response<NewsResponse>


@GET("v1/everything")
suspend fun getAllNews(
    @Query ("All")
    searchQuery:String,
    @Query("page")
    pagenumber:Int=1,
    @Query("apiKey")
    apiKey: String=API_KEY
): Response<NewsResponse>




}