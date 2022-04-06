package com.example.challangechapter4

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase


@Database(entities = [School::class], version = 1)
abstract class SchoolDatabase : RoomDatabase() {
    abstract fun schoolDao() : SchoolDao

    companion object{
        private var INTANCE : SchoolDatabase? = null
        fun getIntance(context: Context): SchoolDatabase? {
            if (INTANCE == null){
                synchronized(SchoolDatabase::class){
                    INTANCE = Room.databaseBuilder(context.applicationContext,
                    SchoolDatabase::class.java, "School.db").build()
                }
            }
            return INTANCE
        }

        fun destroyInstances(){
            INTANCE = null
        }
    }
}