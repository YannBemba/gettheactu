package com.example.gettheactu.ui

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.gettheactu.repo.NewsRepository
import com.example.gettheactu.util.NewsViewModel

class NewsViewModelProviderFactory(
    private val app: Application,
    private val newsRepository: NewsRepository,
): ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return NewsViewModel(app, newsRepository) as T
    }
}