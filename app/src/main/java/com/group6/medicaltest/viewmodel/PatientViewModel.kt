package com.group6.medicaltest.viewmodel

import com.group6.medicaltest.dao.PatientDAO
import com.group6.medicaltest.entity.Patient


import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel

import com.group6.medicaltest.dao.TestDAO
import com.group6.medicaltest.entity.Test
import com.group6.medicaltest.repository.PatientRepository

class PatientViewModel(private val repository: PatientRepository): ViewModel(){

    fun updatePatientDetails(patient: Patient) = viewModelScope.launch {
        repository.update(patient)
    }

}