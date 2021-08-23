package com.example.gettheactu.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.gettheactu.NewsActivity
import com.example.gettheactu.R
import com.example.gettheactu.databinding.FragmentSavedNewsBinding
import com.example.gettheactu.util.NewsViewModel

class SavedNewsFragment : Fragment() {

    private var _binding: FragmentSavedNewsBinding? = null
    private val binding get() = _binding!!
    private lateinit var viewModel: NewsViewModel


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        viewModel = (activity as NewsActivity).viewModel

        return binding.root

    }
}