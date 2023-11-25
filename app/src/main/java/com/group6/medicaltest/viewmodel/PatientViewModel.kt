package com.group6.medicaltest.viewmodel

import com.group6.medicaltest.entity.Patient
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import com.group6.medicaltest.repository.PatientRepository
import kotlinx.coroutines.launch

class PatientViewModel(private val repository: PatientRepository): ViewModel() {

    fun insertPatientDetails(patient: Patient) = viewModelScope.launch {
        repository.insert(patient)
    }

    fun getPatientById(patient: Patient) = viewModelScope.launch {
        repository.getPatientById(patient.patientId)
    }

    fun updatePatientDetails(patient: Patient) = viewModelScope.launch {
        repository.update(patient)
    }
}

class PatientViewModelFactory(private val repository: PatientRepository) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(PatientViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return PatientViewModel(repository) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}