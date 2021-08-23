package com.example.gettheactu.repo

import com.example.gettheactu.api.RetrofitInstance
import com.example.gettheactu.database.ArticleDatabase

class NewsRepository(
    val db: ArticleDatabase
) {
    suspend fun getBreakingNews(countryCode: String, pageNumber: Int) =
        RetrofitInstance.api.getBreakingNews(countryCode, pageNumber)
}