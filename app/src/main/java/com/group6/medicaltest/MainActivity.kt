package com.group6.medicaltest

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val signIn = findViewById<View>(R.id.buttonSignIn) as Button
        signIn.setOnClickListener(){
            val intent = Intent(applicationContext, LoginActivity::class.java)
            startActivity(intent)
        }

//        Implements if Sign Up Activity Created.
//        val signUp = findViewById<View>(R.id.buttonSignUp) as Button
//        signUp.setOnClickListener(){
//            Intent(applicationContext, LoginActivity::class.java)
//        }
    }

}
