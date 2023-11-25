package com.group6.medicaltest

import android.app.Application
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.room.Room
import com.group6.medicaltest.entity.Nurse
import com.group6.medicaltest.repository.NurseRepository
import com.group6.medicaltest.viewmodel.LoginViewModel
import androidx.lifecycle.ViewModelProvider


class LoginActivity (): AppCompatActivity() {
    //private lateinit var nurseId: EditText
    private lateinit var viewModel: LoginViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        val nurseId = findViewById<EditText>(R.id.editTextUserName)
        val password = findViewById<EditText>(R.id.editTextTextPassword)
        val sharedPreferences = getSharedPreferences("MyPrefs", MODE_PRIVATE)

        // Initialize the ViewModel
        viewModel = ViewModelProvider(this).get(LoginViewModel::class.java)

        // Observe the login result
        viewModel.loginResult.observe(this, Observer { loginSuccessful ->
            if (loginSuccessful) {
                // Handle successful login

                // Storing the username (nurseId) into Shared Preferences.
                val editor = sharedPreferences.edit()
                editor.putString("nurseId", nurseId.text.toString())
                editor.commit()

                intent = Intent(applicationContext, SelectOperationActivity::class.java)
                startActivity(intent)
            } else {
                // Handle unsuccessful login
                Toast.makeText(this, "UserName/Password Wrong, Check Again", Toast.LENGTH_LONG).show()
            }
        })

        val login = findViewById<View>(R.id.buttonLogin) as Button
        login.setOnClickListener() {
            // Trigger the login operation in the ViewModel
            viewModel.login(nurseId.text.toString().toInt(), password.text.toString())

        }

        // Fetching the value from Shared Preferences.
        val sh = getSharedPreferences("MyPrefs", MODE_PRIVATE)
        val s1 = sh.getString("nurseId", "")
        // Setting the fetched data in the EditTexts
        nurseId.setText(s1)

    }
}