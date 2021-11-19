package com.myapplication.shopingmarket

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
//import kotlin.concurrent.thread

class HomeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        Thread.sleep(2000)
        setTheme(R.style.Theme_ShopingMarket)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        showToast(1)
    }

    fun logOn(botonLogin: View) {
        val intent = Intent(this,LoginActivity::class.java)
        startActivity(intent)
    }

    fun showToast(int: Int){
        when (int){
            1 ->Toast.makeText(applicationContext,R.string.noLogin,Toast.LENGTH_LONG).show()
            2 ->Toast.makeText(applicationContext,"!Gracias pedaso de animal",Toast.LENGTH_LONG).show()

        }

    }
}