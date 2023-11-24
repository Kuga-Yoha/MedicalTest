package com.group6.medicaltest

import androidx.room.*

@Dao
interface TestDAO {

    @Insert
    fun insertTest(test: Test)

    @Update
    fun updateTest(test: Test)

    @Delete
    fun deleteTest(test: Test)

    @Query("Select * from test")
    fun getALLTest(): List<Test>
}