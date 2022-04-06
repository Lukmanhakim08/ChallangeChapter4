package com.example.challangechapter4

import androidx.room.*

@Dao
interface SchoolDao {

    @Query("SELECT * FROM School")
    fun getAllStudent(): List<School>

    @Insert()
    fun insertSchool(school: School):Long

    @Update
    fun updateShcool(school: School):Int

    @Delete
    fun deleteShcool(school: School):Int
}