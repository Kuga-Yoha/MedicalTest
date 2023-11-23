package com.group6.medicaltest

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.RadioGroup

class SelectOperationActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_select_operation)

        val radioGroup = findViewById<View>(R.id.radioGroupOperation) as RadioGroup
        radioGroup.setOnCheckedChangeListener{radioGroup, checkedId ->
//            val addPatientInfo = findViewById<View>(R.id.radioAddPatientInfo)
//            val addTestInfo = findViewById<View>(R.id.radioAddTestInfo)
//            val viewTestInfo = findViewById<View>(R.id.radioViewTestInfo)
//            val updatePatientInfo = findViewById<View>(R.id.radioUpdatePatientInfo)

            when(radioGroup.getCheckedRadioButtonId()){
                R.id.radioAddPatientInfo -> startActivity(Intent(applicationContext, PatientActivity::class.java))
                R.id.radioAddTestInfo -> startActivity(Intent(applicationContext, TestActivity::class.java))
                R.id.radioViewTestInfo -> startActivity(Intent(applicationContext, ViewTestInfoActivity::class.java))
                R.id.radioUpdatePatientInfo -> startActivity(Intent(applicationContext, UpdateInfoActivity::class.java))


            }

        }

    }
}