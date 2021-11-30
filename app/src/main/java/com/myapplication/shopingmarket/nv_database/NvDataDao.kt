package com.myapplication.shopingmarket.nv_database

import androidx.room.*

@Dao

interface NvDataDao{
    @Query("SELECT * FROM NvData")
    suspend fun getAllRows(): List<NvData>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertRow(user: NvData): Long

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertAllData(user: List<NvData>?): List<Long>

    @Update
    suspend fun undateRow(user: NvData)

    @Delete
    suspend fun deleteRow(user: NvData)
}
