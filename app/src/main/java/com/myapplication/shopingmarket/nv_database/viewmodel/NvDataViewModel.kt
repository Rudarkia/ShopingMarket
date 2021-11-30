package com.myapplication.shopingmarket.nv_database.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.myapplication.shopingmarket.nv_database.NvData
import com.myapplication.shopingmarket.nv_database.repository.NvDataRepository
import kotlinx.coroutines.Job
import kotlinx.coroutines.async
import kotlinx.coroutines.launch

class NvDataViewModel(private val repository: NvDataRepository) : ViewModel() {
    var data: List<NvData>? = null

    fun getAllTableData(): Job{
        return viewModelScope.async {
            data = repository.getAlldata()
        }
    }

    fun getTheData():List<NvData>?{
        return data
    }

    fun  insertData(nv:NvData): Long {
        var idData: Long=0
        viewModelScope.launch{
            idData = repository.inserData(nv)
        }
        return idData

    }

    fun insertAlldata(nv: List<NvData>?): List<Long>?{
        var idData: List<Long>? = null
        viewModelScope.launch {
            idData = repository.insertAllData(nv)
        }
        return idData
    }
}