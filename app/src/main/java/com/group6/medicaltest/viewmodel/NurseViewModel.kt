package com.group6.medicaltest.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import com.group6.medicaltest.dao.NurseDAO
import com.group6.medicaltest.entity.Nurse
import com.group6.medicaltest.repository.NurseRepository
import kotlinx.coroutines.launch

class NurseViewModel(private val repository: NurseRepository): ViewModel() {

    fun getNurseById(nurse: Nurse) = viewModelScope.launch {
        repository.getNurseByIdAndPassword(nurse)
    }
}

class NurseViewModelFactory(private val repository: NurseRepository) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(NurseViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return NurseViewModel(repository) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}