package com.example.garbagemanagementsystem

import android.os.Binder
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.webkit.WebViewClient
import com.example.garbagemanagementsystem.databinding.ActivityWasteSortingBinding

class WasteSorting : AppCompatActivity() {

    private lateinit var binding:ActivityWasteSortingBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityWasteSortingBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.sorting.webViewClient = WebViewClient()
        binding.sorting.loadUrl("https://en.m.wikipedia.org/wiki/Waste_sorting")

    }
}