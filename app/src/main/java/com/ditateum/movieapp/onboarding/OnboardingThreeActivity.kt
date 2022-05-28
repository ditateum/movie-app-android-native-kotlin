package com.ditateum.movieapp.onboarding

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.ditateum.movieapp.R
import com.ditateum.movieapp.databinding.ActivityOnboardingThreeBinding
import com.ditateum.movieapp.sign.SignInActivity

class OnboardingThreeActivity : AppCompatActivity() {
    private lateinit var binding: ActivityOnboardingThreeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityOnboardingThreeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnOnboardingThree.setOnClickListener {
            finishAffinity()
            val intent = Intent(this@OnboardingThreeActivity, SignInActivity::class.java)
            startActivity(intent)
        }
    }
}