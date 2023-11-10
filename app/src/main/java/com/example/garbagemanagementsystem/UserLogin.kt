package com.example.garbagemanagementsystem

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.garbagemanagementsystem.databinding.ActivityMainBinding
import com.example.garbagemanagementsystem.databinding.ActivityUserLoginBinding
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser

class UserLogin : AppCompatActivity() {

    private lateinit var binding: ActivityUserLoginBinding
    private lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityUserLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        auth = FirebaseAuth.getInstance()
        val currentUser: FirebaseUser? = auth.currentUser
        if (currentUser!= null){                            //checking if a user is already sign in or not
            startActivity(Intent(this,UserMenu::class.java))
            finish()
        }

        binding.loginBthUser.setOnClickListener {
            login()
        }

        binding.userRegisterNowBtn.setOnClickListener {
            startActivity(Intent(this,UserSignUp::class.java))
        }
    }


    private fun login(){
        val email = binding.userEmailLogin.text.toString()         //getting user credentials in string format
        val password = binding.userPasswordLogin.text.toString()   //getting user credentials in string format

        //checking if both the fields are filled or not
        if (email.isEmpty() || password.isEmpty()){
            Toast.makeText(this,"Credentials cannot be empty", Toast.LENGTH_SHORT).show()
            return
        }

        //signing in the user with their email and password
        auth.signInWithEmailAndPassword(email,password).addOnCompleteListener(this){
            if(it.isSuccessful){
                Toast.makeText(this,"login Succssfull", Toast.LENGTH_SHORT).show()
                startActivity(Intent(this,UserMenu::class.java))
                finish()
            }else{
                Toast.makeText(this,"Login Failed", Toast.LENGTH_SHORT).show()
            }
        }
    }

}