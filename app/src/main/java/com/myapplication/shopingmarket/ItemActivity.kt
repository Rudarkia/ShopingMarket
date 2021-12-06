package com.myapplication.shopingmarket


import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.firestore.FirebaseFirestore
import com.myapplication.shopingmarket.adapter.ItemSliderAdapter
import com.myapplication.shopingmarket.dataModel.ItemData
import kotlinx.android.synthetic.main.activity_item.*

class ItemActivity : AppCompatActivity(){
//    private var product:ProductEntity?=null
    private lateinit var itemData: ArrayList<ItemData>
    private lateinit var itemId: String

    private var images = mutableListOf<String>()
    private  var dB = FirebaseFirestore.getInstance()
    
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_item)
        itemId = intent.getStringExtra("Product").toString()
        itemData = ArrayList()
//        getItem(itemId)
        Log.d("Query", "DocumentSnapshot data0: $itemId")
        createImage()

    }

    private fun getItem(string: String) {

        dB.collection("product").document(string)
            .get()
        /*dB.collection("product").document(string)
            .get().addOnSuccessListener { document ->
                if (document != null) {
                    Log.d("Query", "DocumentSnapshot data: ${document.data}")
                    product=ProductEntity(
                        document.id,
                        document.get("category").toString(),
                        document.get("discontinued") as Boolean,
                        document.get("image").toString(),
                        document.get("title_en").toString(),
                        document.get("title_es").toString(),
                        document.get("price").toString().toDouble(),
                        document.get("max_quantity").toString().toDouble(),
                        document.get("stock").toString().toDouble(),
                        document.get("current_score").toString().toDouble(),
                        document.get("description").toString()
                    )
                    Log.d("Query", "DocumentSnapshot data0: ${product?.image}")
                }
                Log.d("Query", "DocumentSnapshot data1: ${product?.image}")
            }
            .addOnFailureListener { exception ->
                Log.d("LogError", "get failed with ", exception)
            }*/

    }

    private fun createImage() {
        images = ArrayList()
        var sliderAdapter = ItemSliderAdapter(images as ArrayList<String>)
        item_slider.adapter=sliderAdapter
    }
}