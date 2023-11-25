package com.group6.medicaltest

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import com.group6.medicaltest.entity.Patient
import com.group6.medicaltest.repository.PatientRepository

class PatientViewModel(application: Application) : AndroidViewModel(application) {

    private val repository: PatientRepository
    private val patientById: LiveData<Patient>

    init {
        repository = PatientRepository(application)
        // Assuming you have a default value for patientId, replace it with the actual patientId you want to observe
        patientById = repository.getPatientById(DEFAULT_PATIENT_ID)
    }

    fun getPatientById(patientId: Int): LiveData<Patient> {
        return repository.getPatientById(patientId)
    }

    fun updatePatient(patient: Patient) {
        repository.update(patient)
    }

    companion object {
        private const val DEFAULT_PATIENT_ID = 1 // Replace with the actual default patientId
    }
}
