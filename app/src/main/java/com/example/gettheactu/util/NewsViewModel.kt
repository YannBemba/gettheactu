package com.example.gettheactu.util

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.gettheactu.models.NewsResponse
import com.example.gettheactu.repo.NewsRepository
import kotlinx.coroutines.launch
import retrofit2.Response

class NewsViewModel(
    private val newsRepository: NewsRepository
): ViewModel(){

    val breakingNews: MutableLiveData<Resource<NewsResponse>> = MutableLiveData()
    private var breakingNewsPage = 1

    init {
        getBreakingNews("us")
    }

    private fun getBreakingNews(countryCode: String) = viewModelScope.launch {
        breakingNews.postValue(Resource.Loading())
        val response = newsRepository.getBreakingNews(countryCode, breakingNewsPage)

        breakingNews.postValue(handleBreakingNewsResponse(response))

    }

    private fun handleBreakingNewsResponse(response: Response<NewsResponse>): Resource<NewsResponse> {
        if(response.isSuccessful) {
            response.body()?.let { resultResponse ->
                return Resource.Success(resultResponse)
            }
        }
        return Resource.Error(response.message())
    }

}