package com.myapplication.shopingmarket

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class NvData(
    @PrimaryKey (autoGenerate = true) val pkUser:Int,
    val userId: String?,
    val userName: String?,
    val userMail: String?,
    val userRandomData: String?
)