package com.example.garbagemanagementsystem

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.garbagemanagementsystem.databinding.ActivityRegisterUserBinding
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase

class RegisterUser : AppCompatActivity() {

    private lateinit var binding: ActivityRegisterUserBinding
    private lateinit var database : DatabaseReference

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRegisterUserBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.userRegister2.setOnClickListener {

            val name = binding.userName2.text.toString()
            val email = binding.userEmail2.text.toString()
            val phoneNo = binding.userPhone2.text.toString()
            val address = binding.userAddress2.text.toString()


            if (binding.userName2.text.isNotEmpty() || binding.userEmail2.text.isNotEmpty()
                || binding.userPhone2.text.isNotEmpty() || binding.userAddress2.text.isNotEmpty()){

                database = FirebaseDatabase.getInstance().getReference("Users")
                val user = UserRegisterDc(name,email,phoneNo,address)
                //creating child with firstname as child name
                database.child(name).setValue(user).addOnSuccessListener {
                    binding.userName2.text.clear()
                    binding.userEmail2.text.clear()
                    binding.userPhone2.text.clear()
                    binding.userAddress2.text.clear()

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