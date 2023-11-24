package com.group6.medicaltest

import androidx.room.*

@Dao
interface NurseDAO {

    @Insert
    suspend fun insertNurse(nurse: Nurse)

    @Update
    suspend fun updateNurse(nurse: Nurse)

    @Delete
    suspend fun deleteNurse(nurse: Nurse)

    @Query("Select * from nurse")
    suspend fun getALLNurse(): List<Nurse>
}
