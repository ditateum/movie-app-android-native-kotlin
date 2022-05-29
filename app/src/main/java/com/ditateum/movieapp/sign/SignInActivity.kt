package com.ditateum.movieapp.sign

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.ditateum.movieapp.databinding.ActivitySignInBinding
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase


class SignInActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySignInBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySignInBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnSignIn.setOnClickListener {
            // Write a message to the database
            val database = Firebase.database
            val myRef = database.getReference("message")

            myRef.setValue("Hello, World!")
        }

    }
}