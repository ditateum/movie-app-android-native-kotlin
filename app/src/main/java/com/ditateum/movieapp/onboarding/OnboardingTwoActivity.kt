package com.ditateum.movieapp.onboarding

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.ditateum.movieapp.R
import com.ditateum.movieapp.databinding.ActivityOnboardingTwoBinding

class OnboardingTwoActivity : AppCompatActivity() {
    private lateinit var binding: ActivityOnboardingTwoBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityOnboardingTwoBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnOnboardingTwo.setOnClickListener {
            val intentOnboardingThree = Intent(this@OnboardingTwoActivity, OnboardingThreeActivity::class.java)
            startActivity(intentOnboardingThree)
        }
    }
}