package com.myapplication.shopingmarket.nv_database.repository

import com.myapplication.shopingmarket.nv_database.NvData
import com.myapplication.shopingmarket.nv_database.NvDataDao

class NvDataRepository (private val nvDataDao: NvDataDao) {
    suspend fun getAlldata() : List<NvData>{
        return nvDataDao.getAllRows()
    }

    suspend fun inserData(nv : NvData): Long {
        return nvDataDao.insertRow(nv)
    }

    suspend fun insertAllData(nv: List<NvData>?): List<Long>{
        return nvDataDao.insertAllData(nv)
    }

}