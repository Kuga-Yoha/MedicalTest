package com.group6.medicaltest

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.annotation.WorkerThread
import androidx.room.Room
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch


class MainActivity : AppCompatActivity() {

    private lateinit var database: MedicalTestDatabase
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        database = Room.databaseBuilder(applicationContext, MedicalTestDatabase::class.java,"MedicalTestDB").build()

//        this.insertNurse(Nurse(1, "nurse1", "test1", "dept1", "test"))

//        GlobalScope.launch {
//            database.nurseDao().insertNurse(Nurse(1, "nurse1", "test1", "dept1", "test"))
//        }

        val signIn = findViewById<View>(R.id.buttonSignIn) as Button
        signIn.setOnClickListener{
            val intent = Intent(applicationContext, LoginActivity::class.java)
            startActivity(intent)
        }

//        Implements if Sign Up Activity Created.
//        val signUp = findViewById<View>(R.id.buttonSignUp) as Button
//        signUp.setOnClickListener(){
//            Intent(applicationContext, LoginActivity::class.java)
//        }
    }
//
//    @Suppress("RedundantSuspendModifier")
//    @WorkerThread
//    suspend fun insertNurse(nurse: Nurse) {
//        database.nurseDao().insertNurse(nurse)
//    }
}
