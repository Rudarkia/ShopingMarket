package com.myapplication.shopingmarket

import android.os.Bundle
import android.util.Log
import android.widget.RatingBar
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.snackbar.Snackbar
import com.google.android.material.tabs.TabLayoutMediator
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.ktx.toObject
import com.myapplication.shopingmarket.adapter.ItemSliderAdapter
import com.myapplication.shopingmarket.dataModel.ItemData
import kotlinx.android.synthetic.main.activity_item.*

class ItemActivity : AppCompatActivity(){

    private lateinit var itemSliderAdapter : ItemSliderAdapter
    private lateinit var itemId: String
    private var itemData: ItemData? = null
    private var itemInfo: ItemInfo? = null
    private var images = ArrayList<String>()
    private var dB = FirebaseFirestore.getInstance()
    
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_item)
//        ratingBar.setIsIndicator(true)
        itemId = intent.getStringExtra("Product").toString()
        itemData = ItemData()
        itemInfo = ItemInfo()
        images = ArrayList()
        getItem(itemId)
        createImage()

    }

    private fun getItem(string: String) {

        dB.collection("product").document(string).get().addOnSuccessListener {
            if (it != null) {
                itemData = it.toObject<ItemData>()
                itemData!!.id =it.id
                Log.d("Query", "Data0 ${it.data}")
                item_activity_title.text = itemData!!.title_en
                ratingBar.rating = itemData!!.current_score!!.toFloat()
                score.text = itemData!!.current_score!!.toString()
            }else{
//                Log.d("Query", "No Data0")
            }
        }.addOnFailureListener {
//            Log.d("Query", "Error Data0",it)
        }

        dB.collection("product").document(string).collection("Long_description").document(string).get()
            .addOnSuccessListener {
                if (it != null){
                    itemInfo = it.toObject<ItemInfo>()
                    if (itemInfo?.images != null){
                        val v =itemInfo!!.images.toString().split(",").toTypedArray()
                        for (i in v.indices){
                            images.add(v[i])
//                            Log.d("Query", "image source: ${v[i]}")
                            brand.text = "Brand: "+itemInfo!!.trademark
                        }
                    }

//                    Log.d("Query", "Data1 ${it.data}")
                }else{
                    Log.d("Query", "No Data1")
                    images.add("https://firebasestorage.googleapis.com/v0/b/test-udecaldas.appspot.com/o/resorce%2Fimage_not_found.png?alt=media&token=dab5bdb2-11f7-4dd1-b95b-c09caa891373")
                }
                itemSliderAdapter.notifyDataSetChanged()
            }.addOnFailureListener {
                Log.d("Query", "Error Data1 ",it)
            }
    }

    private fun createImage() {
        itemSliderAdapter = ItemSliderAdapter(this@ItemActivity,images)
        item_slider.adapter=itemSliderAdapter
        TabLayoutMediator(dotsImage,item_slider) { tab, position ->
            //Here you can set something for tab like set text...etc
        }.attach()
        item_slider.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback(){
            override fun onPageSelected(position: Int) {
                super.onPageSelected(position)
//                Snackbar.make(parent_view,"You are selected "+(position+1),Snackbar.LENGTH_SHORT).show()
            }
        })
    }
}