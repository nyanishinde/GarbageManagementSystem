package com.example.garbagemanagementsystem

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.garbagemanagementsystem.databinding.ActivityUserMenuBinding

class UserMenu : AppCompatActivity() {
    private lateinit var binding:ActivityUserMenuBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityUserMenuBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.registerUser.setOnClickListener {
            startActivity(Intent(this,RegisterUser::class.java))
        }
        binding.onSpotComplain.setOnClickListener {
            startActivity(Intent(this,OnSpotComplain::class.java))
        }
        binding.awarenessEvents.setOnClickListener {
            startActivity(Intent(this,Awareness::class.java))
        }
        binding.technique.setOnClickListener {
            startActivity(Intent(this,WasteSorting::class.java))
        }

    }
}