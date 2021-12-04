package com.myapplication.shopingmarket

import android.os.Bundle
import android.os.PersistableBundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class ItemActivity : AppCompatActivity(){

    private var images = mutableListOf<String>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_item)

//        Toast.makeText(applicationContext,intent.getStringExtra("Product"),Toast.LENGTH_LONG).show()  //OnlyTest
        createImage()
    }

    private fun createImage() {

    }
}