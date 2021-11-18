package com.myapplication.shopingmarket

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlin.concurrent.thread

class HomeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        Thread.sleep(2000)
        setTheme(R.style.Theme_ShopingMarket)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
    }

    fun logOn(botonLogin: View) {
        val intent = Intent(this,LoginActivity::class.java)
        startActivity(intent)
    }
}