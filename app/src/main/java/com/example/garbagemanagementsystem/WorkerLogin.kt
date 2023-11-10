package com.example.garbagemanagementsystem

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.garbagemanagementsystem.databinding.ActivityUserLoginBinding
import com.example.garbagemanagementsystem.databinding.ActivityWorkerLoginBinding
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser

class WorkerLogin : AppCompatActivity() {

    private lateinit var binding: ActivityWorkerLoginBinding
    private lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityWorkerLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        auth = FirebaseAuth.getInstance()
        val currentUser: FirebaseUser? = auth.currentUser
        if (currentUser!= null){                            //checking if a user is already sign in or not
            startActivity(Intent(this,WorkerMenu::class.java))
            finish()
        }

        binding.loginBthWorker.setOnClickListener {
            login()
        }

        binding.WorkerRegisterNowBtn.setOnClickListener {
            startActivity(Intent(this,WorkerSignUp::class.java))
        }
    }
    private fun login(){
        val email = binding.workerEmailLogin.text.toString()         //getting user credentials in string format
        val password = binding.workerPasswordLogin.text.toString()   //getting user credentials in string format

        //checking if both the fields are filled or not
        if (email.isEmpty() || password.isEmpty()){
            Toast.makeText(this,"Credentials cannot be empty", Toast.LENGTH_SHORT).show()
            return
        }

        //signing in the user with their email and password
        auth.signInWithEmailAndPassword(email,password).addOnCompleteListener(this){
            if(it.isSuccessful){
                Toast.makeText(this,"login Succssfull", Toast.LENGTH_SHORT).show()
                startActivity(Intent(this,WorkerMenu::class.java))
                finish()
            }else{
                Toast.makeText(this,"Login Failed", Toast.LENGTH_SHORT).show()
            }
        }
    }
}