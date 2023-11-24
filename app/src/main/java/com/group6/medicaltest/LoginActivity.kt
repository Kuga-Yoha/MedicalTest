package com.group6.medicaltest

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class LoginActivity : AppCompatActivity() {
    private lateinit var nurseId: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        val nurseId = findViewById<EditText>(R.id.editTextUserName)
        val sharedPreferences = getSharedPreferences("MyPrefs", MODE_PRIVATE)

        val login = findViewById<View>(R.id.buttonLogin) as Button
        login.setOnClickListener() {
//            Login for Validating Credentials with Database

            var success = 1
            if(success == 1){

                // Storing the username (nurseId) into Shared Preferences.
                val editor = sharedPreferences.edit()
                editor.putString("nurseId", nurseId.text.toString())
                editor.commit()

                intent = Intent(applicationContext, SelectOperationActivity::class.java)
                startActivity(intent)
            } else {
                Toast.makeText(this, "UserName/Password Wrong, Check Again", Toast.LENGTH_LONG).show()
            }
        }

        // Fetching the value from Shared Preferences.
        val sh = getSharedPreferences("MyPrefs", MODE_PRIVATE)
        val s1 = sh.getString("nurseId", "")
        // Setting the fetched data in the EditTexts
        nurseId.setText(s1)

    }
}