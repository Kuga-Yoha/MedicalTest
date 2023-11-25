package com.group6.medicaltest.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteDatabase
import com.group6.medicaltest.dao.NurseDAO
import com.group6.medicaltest.dao.PatientDAO
import com.group6.medicaltest.dao.TestDAO
import com.group6.medicaltest.entity.Nurse
import com.group6.medicaltest.entity.Patient
import com.group6.medicaltest.entity.Test
import com.group6.medicaltest.utils.subscribeOnBackground

@Database(entities=[Nurse::class, Patient::class, Test::class], version = 1)
abstract class MedicalTestDatabase : RoomDatabase() {

    abstract fun nurseDao(): NurseDAO
    abstract  fun patientDao(): PatientDAO
    abstract  fun testDao(): TestDAO



    companion object{
        private var instance: MedicalTestDatabase? = null

        @Synchronized
        fun getInstance(ctx:Context):MedicalTestDatabase{
            if(instance == null)
                instance = Room.databaseBuilder(ctx.applicationContext, MedicalTestDatabase::class.java,
                "medical_test_database").fallbackToDestructiveMigration().addCallback(roomCallback).build()

            return instance!! //asserting instance is not null
        }

        private val roomCallback = object : Callback(){
            override fun onCreate(db: SupportSQLiteDatabase) {
                super.onCreate(db)
                populateDatabase(instance!!)
            }
        }

        private fun populateDatabase(db: MedicalTestDatabase){
                val nurseDao = db.nurseDao()
                val patientDao = db.patientDao()
                val testDao = db.testDao()

            subscribeOnBackground {
                //insert statements

                //Nurse
                nurseDao.insertNurse(Nurse(1, "Prema", "Patel", "ICU", "test"))
                nurseDao.insertNurse(Nurse(2, "Salina", "Sapkota", "Outpatient", "test-sal"))
                nurseDao.insertNurse(Nurse(3, "Sayanthana", "Yoganathan", "General Surgery", "test-saya"))

                //Patient
                //0 is the id as it is autogenerated
                patientDao.insertPatient(Patient(0,"Indrajith","Ram", "Outpatient","2", "A120" ))
                patientDao.insertPatient(Patient(0,"Dilshan","Nayana", "General Surgery","3", "A123" ))
                patientDao.insertPatient(Patient(0,"Haneef","Hussein", "ICU","1", "A120" ))


            }
        }
    }


}