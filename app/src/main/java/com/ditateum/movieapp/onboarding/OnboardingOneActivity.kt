package com.ditateum.movieapp.onboarding

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.ditateum.movieapp.R
import com.ditateum.movieapp.databinding.ActivityOnboardingOneBinding
import com.ditateum.movieapp.sign.SignInActivity

class OnboardingOneActivity : AppCompatActivity() {

    private lateinit var binding: ActivityOnboardingOneBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityOnboardingOneBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnHome.setOnClickListener {
            finishAffinity()
            val intentHome = Intent(this@OnboardingOneActivity, SignInActivity::class.java)
            startActivity(intentHome)
        }

        binding.btnOnboardingOne.setOnClickListener {
            val intentOnboardingTwo = Intent(this@OnboardingOneActivity, OnboardingTwoActivity::class.java)
            startActivity(intentOnboardingTwo)
        }
    }
}