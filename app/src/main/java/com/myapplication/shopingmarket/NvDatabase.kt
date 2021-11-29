package com.myapplication.shopingmarket

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = arrayOf(NvData::class), version = 1)

abstract class NvDatabase : RoomDatabase(){
    abstract fun  nvDataDao() : NvDataDao

    companion object {
        @Volatile
        private var INSTANCE : NvDatabase? =null

        fun  getDatabase(context: Context): NvDatabase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(context.applicationContext,
                    NvDatabase::class.java,"NvDatabase").build()
                INSTANCE=instance
                // return instance
                instance
            }
        }
    }
}