package com.example.gettheactu.api

import com.example.gettheactu.models.NewsResponse
import com.example.gettheactu.util.Constants.Companion.API_KEY
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface NewsAPI {

    @GET("v2/top-headlines")
    suspend fun getBreakingNews(
        @Query("country")
        countryCode: String = "fr",
        @Query("page")
        pageNum: Int = 1,
        @Query("apiKey")
        apiKey:  String = API_KEY
    ): Response<NewsResponse>

    @GET("v2/everything")
    suspend fun searchNews(
        @Query("q")
        searchQuery: String,
        @Query("page")
        pageNum: Int = 1,
        @Query("apiKey")
        apiKey:  String = API_KEY
    ): Response<NewsResponse>


}