package com.example.gettheactu

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import androidx.navigation.ui.setupWithNavController
import com.example.gettheactu.database.ArticleDatabase
import com.example.gettheactu.databinding.ActivityNewsBinding
import com.example.gettheactu.repo.NewsRepository
import com.example.gettheactu.ui.NewsViewModelProviderFactory
import com.example.gettheactu.util.NewsViewModel

class NewsActivity : AppCompatActivity() {

    private lateinit var binding: ActivityNewsBinding

    lateinit var viewModel: NewsViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityNewsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Bottom Navigation Setup

        val bottomNav = binding.bottomNav
        val newsNavHostFragment = binding.newsNavHostFragment

        val newsRepository = NewsRepository(ArticleDatabase(this))
        val viewModelProviderFactory = NewsViewModelProviderFactory(application ,newsRepository)

        viewModel = ViewModelProvider(this, viewModelProviderFactory)[NewsViewModel::class.java]

        bottomNav.setupWithNavController(newsNavHostFragment.findNavController())


    }
}