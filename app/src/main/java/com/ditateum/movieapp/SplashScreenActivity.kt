package com.ditateum.movieapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import com.ditateum.movieapp.onboarding.OnboardingOneActivity

class SplashScreenActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen)

       Handler(Looper.getMainLooper()).postDelayed({
           val intent = Intent(this@SplashScreenActivity, OnboardingOneActivity::class.java)
           startActivity(intent)
           finish()
       }, 4000)
    }
}