package com.group6.medicaltest

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.group6.medicaltest.entity.Patient

class UpdateInfoActivity : AppCompatActivity() {

    private lateinit var patientViewModel: PatientViewModel
    private lateinit var editTextFirstName: EditText
    private lateinit var editTextLastName: EditText
    private lateinit var editTextDepartment: EditText
    private lateinit var editTextRoom: EditText
    private lateinit var buttonUpdate: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_update_info)

        // Initialize UI elements
        editTextFirstName = findViewById(R.id.editTextFirstName)
        editTextLastName = findViewById(R.id.editTextLastName)
        editTextDepartment = findViewById(R.id.editTextDepartment)
        editTextRoom = findViewById(R.id.editTextRoom)
        buttonUpdate = findViewById(R.id.buttonUpdate)


        val nurseId = intent.getStringExtra("nurseId").toString().toInt()

        // Assuming you have a ViewModel class for Patient
        patientViewModel = ViewModelProvider(this).get(PatientViewModel::class.java)

        // Get patientId from Intent (you need to pass it from the previous activity)
        val patientId = intent.getIntExtra("patientId", -1)

        // Fetch and observe patient data for the given patientId
        patientViewModel.getPatientById(patientId).observe(this, { patient ->
            if (patient != null) {
                // Display the current information in the EditText fields
                editTextFirstName.setText(patient.firstName)
                editTextLastName.setText(patient.lastName)
                editTextDepartment.setText(patient.department)
                editTextRoom.setText(patient.room)
            }
        })

        // Set up click listener for the Update button
        buttonUpdate.setOnClickListener {
            // Retrieve updated data from UI elements
            val updatedFirstName = editTextFirstName.text.toString()
            val updatedLastName = editTextLastName.text.toString()
            val updatedDepartment = editTextDepartment.text.toString()
            val updatedRoom = editTextRoom.text.toString()

            // Create a Patient object with updated information
            val updatedPatient = Patient(patientId, updatedFirstName, updatedLastName, updatedDepartment, nurseId, updatedRoom)

            // Update patient information in the ViewModel
            patientViewModel.updatePatient(updatedPatient)

            // Finish the activity or navigate to another screen as needed
            finish()
        }
    }
}
