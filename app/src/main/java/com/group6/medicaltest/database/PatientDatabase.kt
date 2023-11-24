package com.group6.medicaltest.database

import androidx.room.Database
import com.group6.medicaltest.Nurse
import com.group6.medicaltest.Patient
import com.group6.medicaltest.Test

@Database(entities=[Nurse::class, Patient::class, Test::class], version = 1)
class PatientDatabase {



}