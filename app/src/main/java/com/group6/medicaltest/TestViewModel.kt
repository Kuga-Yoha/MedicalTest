package com.group6.medicaltest

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import com.group6.medicaltest.entity.Test
import com.group6.medicaltest.repository.TestRepository

class TestViewModel(application: Application) : AndroidViewModel(application) {

    private val repository: TestRepository
    private val testsForPatient: LiveData<List<Test>>

    init {
        repository = TestRepository(application)
        testsForPatient = repository.allTests
    }

//    fun getTestsForPatient(patientId: Int): LiveData<List<Test>> {
//        return repository.getTestsForPatient(patientId)
//    }
}
