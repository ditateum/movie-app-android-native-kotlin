package com.ditateum.movieapp.onboarding

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.ditateum.movieapp.R
import com.ditateum.movieapp.databinding.ActivityOnboardingOneBinding
import com.ditateum.movieapp.sign.SignInActivity
import com.ditateum.movieapp.utils.Preferences

class OnboardingOneActivity : AppCompatActivity() {

    private lateinit var binding: ActivityOnboardingOneBinding
    lateinit var preferences: Preferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityOnboardingOneBinding.inflate(layoutInflater)
        setContentView(binding.root)

        preferences = Preferences(this)
        if (preferences.getValues("ditateum.onboarding") == "1") {
            val intentHome = Intent(this@OnboardingOneActivity, SignInActivity::class.java)
            startActivity(intentHome)
        }

        binding.btnHome.setOnClickListener {
            preferences.setValues("ditateum.onboarding", "1")
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