package com.group6.medicaltest.dao

import androidx.lifecycle.LiveData
import androidx.room.*
import com.group6.medicaltest.entity.Test


@Dao
interface TestDAO {

    //    We need only Insert and Fetch
    @Insert
    fun insertTest(test: Test)

    @Update
    fun updateTest(test: Test)

    @Delete
    fun deleteTest(test: Test)

    @Query("Select * from test")
    fun getAllTests(): LiveData<List<Test>>

//    @Query("SELECT * From test where patientId= : patientId")
    fun getTestReportByPatientId(patientId: Int): LiveData<List<Test>>
}