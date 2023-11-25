package com.group6.medicaltest.entity

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey

@Entity(
    tableName="test",
    foreignKeys =[
        ForeignKey(
            entity = Nurse::class,
            parentColumns = ["nurseId"],
            childColumns = ["nurseId"],
            onDelete = ForeignKey.CASCADE
        ),
        ForeignKey(
            entity = Patient::class,
            parentColumns = ["patientId"],
            childColumns = ["patientId"],
            onDelete = ForeignKey.CASCADE
        ),
    ]
)
data class Test(
    @PrimaryKey(autoGenerate = true)
    val testId: Long,
    val patientId: String,
    val nurseId: Long,
    val BPL: String,
    val BPH: String,
    val temperature: String,
)
