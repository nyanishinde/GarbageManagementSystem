package com.example.garbagemanagementsystem

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.garbagemanagementsystem.databinding.ActivityUserSignUpBinding
import com.example.garbagemanagementsystem.databinding.ActivityWorkerSignUpBinding
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

class WorkerSignUp : AppCompatActivity() {

    private lateinit var binding: ActivityWorkerSignUpBinding  //setting view binding for the activity
    private lateinit var auth: FirebaseAuth  //declaring instance of firebase authentication so we can perform actions

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityWorkerSignUpBinding.inflate(layoutInflater)
        setContentView(binding.root)

        auth = Firebase.auth  //initializing the firebase instance

        binding.btnSignupRegWorker.setOnClickListener{
            signUpUser()
            finish()
        }

        binding.btnSigninRegWorker.setOnClickListener {
            startActivity(Intent(this,WorkerLogin::class.java))
            finish()
        }
    }
    private fun signUpUser(){

        val email = binding.regEmailWorker.text.toString() //getting user credentials in string format
        val password = binding.regPasswordWorker.text.toString()  //getting user credentials in string format
        val password2 = binding.regRePasswordWorker.text.toString()   //getting user credentials in string format

        //checking the fields if they are filled or not
        if (email.isBlank()||password.isBlank()||password2.isBlank()){
            Toast.makeText(this,"Email and password cannot be empty", Toast.LENGTH_SHORT).show()
            return
        }

        //checking if the entered password is same are re-entered password
        if (password != password2){
            Toast.makeText(this,"Password doesn't match", Toast.LENGTH_SHORT).show()
            return
        }

        //creating a user with email and password
        auth.createUserWithEmailAndPassword(email,password).addOnCompleteListener (this) {
            if (it.isSuccessful){
                Toast.makeText(this,"Successfully sighup", Toast.LENGTH_SHORT).show()
                finish()
            }else{
                Toast.makeText(this, "Singed Up Failed!", Toast.LENGTH_SHORT).show()
            }
        }
    }
}