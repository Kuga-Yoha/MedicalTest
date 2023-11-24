package com.group6.medicaltest

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [Patient::class, Nurse::class, Test::class], version=1)
abstract class MedicalTestDatabase: RoomDatabase() {

    abstract fun patientDao() : PatientDAO
    abstract fun nurseDao() : NurseDAO
    abstract fun TestDao() : TestDAO
//
//    companion object {
//        // Singleton prevents multiple instances of database opening at the
//        // same time.
//        @Volatile
//        private var INSTANCE: MedicalTestDatabase? = null
//
//        fun getDatabase(context: Context): MedicalTestDatabase {
//            // if the INSTANCE is not null, then return it,
//            // if it is, then create the database
//            return INSTANCE ?: synchronized(this) {
//                val instance = Room.databaseBuilder(
//                    context.applicationContext,
//                    MedicalTestDatabase::class.java,
//                    "MedicalTestDB"
//                ).build()
//                INSTANCE = instance
//                // return instance
//                instance
//            }
//        }
//    }
}