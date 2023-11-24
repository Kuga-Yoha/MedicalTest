package com.group6.medicaltest

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName="patient")
data class Patient(
    @PrimaryKey(autoGenerate = true)
    val patientId: Long,
    val firstName: String,
    val lastName: String,
    val department: String,
//    val nursId:
    val room: String
)

