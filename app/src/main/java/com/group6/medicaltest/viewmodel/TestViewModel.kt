package com.group6.medicaltest.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import com.group6.medicaltest.dao.TestDAO
import com.group6.medicaltest.entity.Patient
import com.group6.medicaltest.entity.Test
import com.group6.medicaltest.repository.TestRepository
import kotlinx.coroutines.launch

class TestViewModel(private val repository: TestRepository): ViewModel(){

    fun insertTestDetails(test: Test) = viewModelScope.launch {
        repository.insert(test)
    }

    fun getTestDetailsByPatientId(test: Test) = viewModelScope.launch {
        repository.getTestReportByPatientId(test.patientId)
    }
}

class TestViewModelFactory(private val repository: TestRepository) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(TestViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return TestViewModel(repository) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}