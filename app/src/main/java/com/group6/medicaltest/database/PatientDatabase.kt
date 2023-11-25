package com.group6.medicaltest.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.group6.medicaltest.dao.NurseDAO
import com.group6.medicaltest.dao.PatientDAO
import com.group6.medicaltest.dao.TestDAO
import com.group6.medicaltest.entity.Nurse
import com.group6.medicaltest.entity.Patient
import com.group6.medicaltest.entity.Test

@Database(entities = [Nurse::class, Patient::class, Test::class], version = 1)
abstract class PatientDatabase : RoomDatabase() {

    abstract fun nurseDao(): NurseDAO
    abstract fun patientDao(): PatientDAO
    abstract fun testDao(): TestDAO

    companion object {
        @Volatile
        private var instance: PatientDatabase? = null

        fun getInstance(context: Context): PatientDatabase {
            return instance ?: synchronized(this) {
                instance ?: buildDatabase(context).also { instance = it }
            }
        }

        private fun buildDatabase(context: Context): PatientDatabase {
            return Room.databaseBuilder(
                context.applicationContext,
                PatientDatabase::class.java,
                "patient_database"
            ).fallbackToDestructiveMigration().build()
        }
    }
}
