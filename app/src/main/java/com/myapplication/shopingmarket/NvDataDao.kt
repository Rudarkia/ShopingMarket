package com.myapplication.shopingmarket

import androidx.room.*

@Dao

interface NvDataDao{
    @Query("SELECT * FROM NvData")
    suspend fun getAllRows(): List<NvData>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertRow(user: NvData): Long

    @Update
    suspend fun undateRow(user: NvData)

    @Delete
    suspend fun deleteRow(user: NvData)
}
