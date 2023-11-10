package com.example.garbagemanagementsystem

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.garbagemanagementsystem.databinding.ActivityAwarenessBinding
import com.example.garbagemanagementsystem.databinding.ActivityWorkerMenuBinding

class WorkerMenu : AppCompatActivity() {
    private lateinit var binding: ActivityWorkerMenuBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityWorkerMenuBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.DailyPickup.setOnClickListener {
            startActivity(Intent(this,DailyPickup::class.java))
        }
        binding.onSpotCollection.setOnClickListener {
            startActivity(Intent(this,ComplainPickup::class.java))
        }
        binding.awarenessEvents2.setOnClickListener {
            startActivity(Intent(this,Awareness::class.java))
        }
        binding.technique2.setOnClickListener {
            startActivity(Intent(this,WasteSorting::class.java))
        }

    }
}