package com.group6.medicaltest.entity

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey

@Entity(
    tableName="patient",
    foreignKeys = [ForeignKey(
        entity = Nurse::class,
        parentColumns = ["nurseId"],
        childColumns = ["nurseId"],
        onDelete = ForeignKey.CASCADE
    )]


    )
data class Patient(
    @PrimaryKey(autoGenerate = true)
    val patientId: Long,
    val firstName: String,
    val lastName: String,
    val department: String,
    val nurseId: Long,
    val room: String
)

