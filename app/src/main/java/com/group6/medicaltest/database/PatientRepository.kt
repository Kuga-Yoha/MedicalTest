package com.group6.medicaltest.database

import android.app.Application
import androidx.lifecycle.LiveData
import com.group6.medicaltest.dao.PatientDAO
import com.group6.medicaltest.entity.Patient

import com.group6.medicaltest.utils.subscribeOnBackground

class PatientRepository(application:Application) {

    private var patientDao : PatientDAO
    private var allPatients : LiveData<List<Patient>>
    
    private val database = MedicalTestDatabase.getInstance(application)

    init {
            patientDao = database.patientDao()
            allPatients = patientDao.getAllPatients()
    }

    fun insert(patient:Patient){
        subscribeOnBackground {
            patientDao.insertPatient(patient)
        }
    }

    fun update(patient:Patient){
        subscribeOnBackground {
            patientDao.updatePatient(patient)
        }
    }

    fun delete(patient:Patient){
        subscribeOnBackground {
            patientDao.deletePatient(patient)
        }
    }

}

