package com.group6.medicaltest.dao

import androidx.lifecycle.LiveData
import androidx.room.*
import com.group6.medicaltest.entity.Nurse
import kotlinx.coroutines.flow.Flow


@Dao
interface NurseDAO {

    @Insert
    fun insertNurse(nurse: Nurse)

    @Update
    fun updateNurse(nurse: Nurse)

    @Delete
    fun deleteNurse(nurse: Nurse)

    @Query("Select * from nurse")
    fun getAllNurses(): LiveData<List<Nurse>>

    @Query("select * from nurse where nurseId = :nurseId and password = :password")
    fun findByIdAndPassword(nurseId: Int, password: String): LiveData<Nurse>
}
