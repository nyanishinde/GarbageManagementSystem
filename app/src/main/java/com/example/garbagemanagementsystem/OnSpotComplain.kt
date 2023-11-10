package com.example.garbagemanagementsystem

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.garbagemanagementsystem.databinding.ActivityOnSpotComplainBinding
import com.example.garbagemanagementsystem.databinding.ActivityRegisterUserBinding
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase

class OnSpotComplain : AppCompatActivity() {

    private lateinit var binding: ActivityOnSpotComplainBinding
    private lateinit var database : DatabaseReference

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityOnSpotComplainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.complainRegister.setOnClickListener {

            val name = binding.complainName.text.toString()
            val email = binding.complainEmail.text.toString()
            val details = binding.complainDetails.text.toString()
            val phoneNo = binding.complainPhone.text.toString()
            val address = binding.complainAddress.text.toString()


            if (binding.complainName.text.isNotEmpty() || binding.complainEmail.text.isNotEmpty()||
                binding.complainDetails.text.isNotEmpty()|| binding.complainPhone.text.isNotEmpty()
                || binding.complainAddress.text.isNotEmpty()){

                database = FirebaseDatabase.getInstance().getReference("Complains")
                val complain = complainDc(name,email,phoneNo,details,address)
                //creating child with firstname as child name
                database.child(name).setValue(complain).addOnSuccessListener {
                    binding.complainName.text.clear()
                    binding.complainEmail.text.clear()
                    binding.complainDetails.text.clear()
                    binding.complainPhone.text.clear()
                    binding.complainAddress.text.clear()

                    Toast.makeText(this,"Data Entered Successfully", Toast.LENGTH_SHORT).show()
                }.addOnFailureListener {
                    Toast.makeText(this,"Data Entry Failed", Toast.LENGTH_SHORT).show()
                }
            }else{
                Toast.makeText(this,"Fields cannot be empty", Toast.LENGTH_SHORT).show()
            }

        }

    }
}