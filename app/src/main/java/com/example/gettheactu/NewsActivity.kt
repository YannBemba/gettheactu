package com.example.gettheactu

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.findNavController
import androidx.navigation.ui.setupWithNavController
import com.example.gettheactu.databinding.ActivityNewsBinding

class NewsActivity : AppCompatActivity() {

    private lateinit var binding: ActivityNewsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityNewsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Bottom Navigation Setup

        val bottomNav = binding.bottomNav
        val newsNavHostFragment = binding.newsNavHostFragment

        bottomNav.setupWithNavController(newsNavHostFragment.findNavController())


    }
}