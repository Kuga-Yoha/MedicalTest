package com.group6.medicaltest

import androidx.room.*

@Dao
interface NurseDAO {

    @Insert
    fun insertNurse(nurse: Nurse)

    @Update
    fun updateNurse(nurse: Nurse)

    @Delete
    fun deleteNurse(nurse: Nurse)

    @Query("SELECT * FROM nurse")
    fun getAllNurse(): List<Nurse>
}
