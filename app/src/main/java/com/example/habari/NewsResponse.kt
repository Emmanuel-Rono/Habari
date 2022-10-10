package com.example.habari

data class NewsResponse(
    val articles: List<Article>,
    val sortBy: String,
    val source: String,
    val status: String
)