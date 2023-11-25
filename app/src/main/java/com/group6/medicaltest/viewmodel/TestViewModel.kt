package com.group6.medicaltest.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.group6.medicaltest.dao.TestDAO
import com.group6.medicaltest.entity.Test
import com.group6.medicaltest.repository.TestRepository

class TestViewModel(private val TestDAO: TestDAO): ViewModel(){

    fun getTestResult(): LiveData<List<Test>> = TestDAO.getTestReport()

    fun insertTestResult() = TestDAO.insertTest(test: Test)


}