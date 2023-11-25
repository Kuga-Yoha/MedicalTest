package com.group6.medicaltest.dao

import androidx.lifecycle.LiveData
import androidx.room.*
import com.group6.medicaltest.entity.Patient

@Dao
interface PatientDAO {

//    We need only Insert, Fetch and Update
    @Insert
    fun insertPatient(patient: Patient)

    @Update
    fun updatePatient(patient: Patient)

    @Delete
    fun deletePatient(patient: Patient)

    @Query("Select * from patient")
    fun getAllPatients(): LiveData<List<Patient>>
    abstract fun getPatientById(patientId: Int): LiveData<Patient>
}