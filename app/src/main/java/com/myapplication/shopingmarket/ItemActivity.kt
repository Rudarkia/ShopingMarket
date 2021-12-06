package com.myapplication.shopingmarket


import android.content.Context
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.ktx.toObject
import com.myapplication.shopingmarket.adapter.ItemSliderAdapter
import com.myapplication.shopingmarket.dataModel.ItemData
import kotlinx.android.synthetic.main.activity_item.*

class ItemActivity : AppCompatActivity(){

    private var itemData: ItemData? = null
    private lateinit var itemId: String

    private var images = mutableListOf<String>()
    private  var dB = FirebaseFirestore.getInstance()
    
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_item)
        itemId = intent.getStringExtra("Product").toString()
        itemData = ItemData()
        getItem(itemId)
        createImage()

    }

    private fun getItem(string: String) {

        dB.collection("product").document(string).get().addOnSuccessListener {
            if (it != null) {
                itemData = it.toObject<ItemData>()
                Log.d("Query", "Data0 ${it.data}")
            }else{
                Log.d("Query", "No Data")
            }
        }.addOnFailureListener {
            Log.d("Query", "Error ",it)
        }

        dB.collection("product").document(string).collection("Long_description").document(string).get()
            .addOnSuccessListener {
                    Log.d("Query", "Data ${it.data}")
            }

    }

    private fun createImage() {
        images = ArrayList()
        var sliderAdapter = ItemSliderAdapter(images as ArrayList<String>)
        item_slider.adapter=sliderAdapter
    }
}