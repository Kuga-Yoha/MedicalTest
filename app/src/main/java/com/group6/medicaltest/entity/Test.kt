package com.group6.medicaltest.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName="test")
data class Test(
    @PrimaryKey(autoGenerate = true)
    val testId: Long,
    val patientId: String,
    val nurseId: Long,
    val BPL: String,
    val BPH: String,
    val temperature: String,
)
