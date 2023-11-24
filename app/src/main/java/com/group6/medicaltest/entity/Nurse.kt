package com.group6.medicaltest.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName="nurse")
data class Nurse(
    @PrimaryKey(autoGenerate = true)
    val nurseId: Long,
    val firstName: String,
    val lastName: String,
    val department: String,
    val password: String
)
