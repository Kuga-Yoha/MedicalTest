package com.group6.medicaltest.dao

import androidx.lifecycle.LiveData
import androidx.room.*
import com.group6.medicaltest.entity.Patient

@Dao
interface PatientDAO {

    @Insert
    fun insertPatient(patient: Patient)

    @Update
    fun updatePatient(patient: Patient)

    @Delete
    fun deletePatient(patient: Patient)

    @Query("Select * from patient")
    fun getAllPatients(): LiveData<List<Patient>>
}