package com.group6.medicaltest

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Toast

class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        val login = findViewById<View>(R.id.buttonLogin) as Button
        login.setOnClickListener() {
//            Login for Validating Credentials with Database

            var success = 1
            if(success == 1){
                intent = Intent(applicationContext, SelectOperationActivity::class.java)
                startActivity(intent)
            } else {
                Toast.makeText(this, "UserName/Password Wrong, Check Again", Toast.LENGTH_LONG).show()
            }
        }

    }
}