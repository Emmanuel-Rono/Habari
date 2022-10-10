package com.example.habari.db

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.habari.Articles

@Dao
interface articlesDao
{
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    //function to do the stuff
    suspend fun insertArticles(articles: Articles)
    @Query( "SELECT * FROM news_Articles  ")
    suspend  fun getAllArticles():LiveData<List<Articles >>
    @Delete
    suspend fun deleteArticle(articles: Articles)

}