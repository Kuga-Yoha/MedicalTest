package com.group6.medicaltest.repository

import android.app.Application
import androidx.lifecycle.LiveData
import com.group6.medicaltest.dao.TestDAO
import com.group6.medicaltest.database.MedicalTestDatabase
import com.group6.medicaltest.entity.Test

import com.group6.medicaltest.utils.subscribeOnBackground

class TestRepository(application:Application) {

    private var testDao : TestDAO
    private var allTests : LiveData<List<Test>>

    private val database = MedicalTestDatabase.getInstance(application)

    init {
            testDao = database.testDao()
            allTests = testDao.getAllTests()
    }

    fun insert(test:Test){
        subscribeOnBackground {
            testDao.insertTest(test)
        }
    }

    fun update(test: Test){
        subscribeOnBackground {
            testDao.updateTest(test)
        }
    }

    fun delete(test:Test){
        subscribeOnBackground {
            testDao.deleteTest(test)
        }
    }

}

