package com.group6.medicaltest.database

import android.app.Application
import androidx.lifecycle.LiveData
import com.group6.medicaltest.dao.NurseDAO
import com.group6.medicaltest.entity.Nurse

import com.group6.medicaltest.utils.subscribeOnBackground

class NurseRepository(application:Application) {

    private var nurseDao : NurseDAO
    private var allNurses : LiveData<List<Nurse>>

    private val database = MedicalTestDatabase.getInstance(application)

    init {
            nurseDao = database.nurseDao()
            allNurses = nurseDao.getAllNurses()
    }

    fun insert(nurse: Nurse){
        subscribeOnBackground {
            nurseDao.insertNurse(nurse)
        }
    }

    fun update(nurse: Nurse){
        subscribeOnBackground {
            nurseDao.updateNurse(nurse)
        }
    }

    fun delete(nurse: Nurse){
        subscribeOnBackground {
            nurseDao.deleteNurse(nurse)
        }
    }

}

