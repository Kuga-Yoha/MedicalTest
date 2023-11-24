package com.group6.medicaltest

import androidx.room.*

@Dao
interface PatientDAO {

    @Insert
    fun insertPatient(patient: Patient)

    @Update
    fun updatePatient(patient: Patient)

    @Delete
    fun deletePatient(patient: Patient)

    @Query("Select * from patient")
    fun getALLPatient(): List<Patient>
}