package com.example.garbagemanagementsystem

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.garbagemanagementsystem.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        binding.asUserId.setOnClickListener {
            startActivity(Intent(this,UserLogin::class.java))
        }
        binding.asWorkerId.setOnClickListener {
            startActivity(Intent(this,WorkerLogin::class.java))
        }
    }
}