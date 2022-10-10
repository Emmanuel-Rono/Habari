package com.example.habari

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(
    tableName="news_Articles"
)
data class Article(
    @PrimaryKey(autoGenerate = true)
    var id: Int? =null,
    val author: String,
    val description: String,
    val publishedAt: String,
    val title: String,
    val url: String,
    val urlToImage: String
)