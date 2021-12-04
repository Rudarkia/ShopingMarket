package com.myapplication.shopingmarket

import android.os.Bundle
import android.os.PersistableBundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_home.*
import kotlinx.android.synthetic.main.activity_item.*

class ItemActivity : AppCompatActivity(){
    private lateinit var product: ProductEntity
    private var images = mutableListOf<String>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_item)

//        product= ProductEntity(intent.getStringExtra("Product").toString(),"yhtdf",false,"wew","we","wewer",(10).toDouble(),(2).toDouble(),"none")
        Toast.makeText(applicationContext,intent.getStringExtra("Product"),Toast.LENGTH_LONG).show()  //OnlyTest

        createImage()
    }

    private fun createImage() {
        images = ArrayList()
        var sliderAdapter = ItemSliderAdapter(images as ArrayList<String>)
        item_slider.adapter=sliderAdapter
    }
}