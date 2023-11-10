package com.example.garbagemanagementsystem

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.webkit.WebViewClient
import com.example.garbagemanagementsystem.databinding.ActivityAwarenessBinding

class Awareness : AppCompatActivity() {

    private lateinit var binding: ActivityAwarenessBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAwarenessBinding.inflate(layoutInflater)
        setContentView(binding.root)


//        Setting a WebView containing a websites url that shows the upcoming awareness events.
        binding.awareness.webViewClient = WebViewClient()
        binding.awareness.loadUrl("https://teresas.ac.in/awareness-campaign-on-waste-disposal/")
    }
}