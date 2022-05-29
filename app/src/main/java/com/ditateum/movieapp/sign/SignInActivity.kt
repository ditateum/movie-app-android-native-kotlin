package com.ditateum.movieapp.sign

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.ditateum.movieapp.HomeActivity
import com.ditateum.movieapp.databinding.ActivitySignInBinding
import com.ditateum.movieapp.model.User
import com.ditateum.movieapp.utils.Preferences
import com.google.firebase.database.*


class SignInActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySignInBinding
    private lateinit var iUsername: String
    private lateinit var iPassword: String

    lateinit var mDatabase: DatabaseReference
    lateinit var preferences: Preferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySignInBinding.inflate(layoutInflater)
        setContentView(binding.root)

        mDatabase = FirebaseDatabase.getInstance().getReference("User")
        preferences = Preferences(this)

        preferences.setValues("ditateum.onboarding", "1")
        if (preferences.getValues("ditateum.status") == "1") {
            finishAffinity()

            val intentHome = Intent(this@SignInActivity, HomeActivity::class.java)
            startActivity(intentHome)
        }

        binding.btnSignIn.setOnClickListener {
            iUsername = binding.etUsername.text.toString()
            iPassword = binding.etPassword.text.toString()

            if (iUsername == "" && iUsername.isEmpty()) {
                binding.etUsername.error = "Silahkan tulis username anda"
            } else if (iPassword == "" && iPassword.isEmpty()) {
                binding.etPassword.error = "Silahkan tulis password anda"
            } else {
                pushLogin(iUsername, iPassword)
            }
        }

        binding.btnSignUp.setOnClickListener {
            val intentSignUp = Intent(this@SignInActivity, SignUpActivity::class.java)
            startActivity(intentSignUp)
        }

    }

    private fun pushLogin(username: String, password: String) {
        mDatabase.child(iUsername).addValueEventListener(object: ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                var user = snapshot.getValue(User::class.java)

                if (user == null) {
                    Toast.makeText(this@SignInActivity, "Username Tidak Ditemukan", Toast.LENGTH_LONG).show()
                } else {
                    if (user.password == iPassword) {
                        preferences.setValues("ditateum.name", user.name.toString())
                        preferences.setValues("ditateum.email", user.email.toString())
                        preferences.setValues("ditateum.username", user.username.toString())
                        preferences.setValues("ditateum.password", user.password.toString())
                        preferences.setValues("ditateum.url", user.url.toString())
                        preferences.setValues("ditateum.saldo", user.saldo.toString())
                        preferences.setValues("ditateum.status", "1")

                        val intentHome = Intent(this@SignInActivity, HomeActivity::class.java)
                        startActivity(intentHome)
                    } else {
                        Toast.makeText(this@SignInActivity, "Password Anda Salah", Toast.LENGTH_LONG).show()
                    }
                }
            }

            override fun onCancelled(error: DatabaseError) {
                Toast.makeText(this@SignInActivity, error.message, Toast.LENGTH_LONG).show()
            }

        })
    }
}