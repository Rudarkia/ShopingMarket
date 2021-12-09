package com.myapplication.shopingmarket

import android.graphics.Paint
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.tabs.TabLayoutMediator
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.ktx.toObject
import com.myapplication.shopingmarket.adapter.ItemSliderAdapter
import com.myapplication.shopingmarket.dataModel.ItemData
import com.myapplication.shopingmarket.dataModel.ItemInfo
import kotlinx.android.synthetic.main.activity_item.*

class ItemActivity : AppCompatActivity(){

    private lateinit var itemSliderAdapter : ItemSliderAdapter
    private lateinit var itemId: String
    private var itemData: ItemData? = null
    private var itemInfo: ItemInfo? = null
    private var totalPrice: Float? = null
    private var images = ArrayList<String>()
    private var dB = FirebaseFirestore.getInstance()
    
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_item)
        amount_spinner.isEnabled = false
        itemId = intent.getStringExtra("Product").toString()
        currency_n.visibility = View.INVISIBLE
        normal_price.visibility = View.INVISIBLE
        itemData = ItemData()
        itemInfo = ItemInfo()
        images = ArrayList()
        getItem(itemId)
        createImage()

        amount_spinner.onItemSelectedListener=object : AdapterView.OnItemSelectedListener{
            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
                if (itemData!!.price != null || itemInfo!!.discount != null ){
                    val myPrice = (itemData!!.price?.minus(itemInfo!!.discount!!))
                    val normalPrice : Float = itemData!!.price!! * (position+1).toFloat()

                    totalPrice=myPrice!! * (position+1).toFloat()
                    total_price.text=totalPrice.toString()
                    normal_price.text=normalPrice.toString()
                }
                if (itemInfo!!.discount!! > 0F){
                    normal_price.paint.flags = Paint.STRIKE_THRU_TEXT_FLAG
                    currency_n.paint.flags = Paint.STRIKE_THRU_TEXT_FLAG
                    currency_n.visibility = View.VISIBLE
                    normal_price.visibility = View.VISIBLE
                }

            }

            override fun onNothingSelected(parent: AdapterView<*>?) {
            }

        }

    }

    private fun getItem(string: String) {

        dB.collection("product").document(string).get().addOnSuccessListener {
            if (it != null) {
                itemData = it.toObject<ItemData>()   /***Asignacion de datos***/
                itemData!!.id =it.id
//                Log.d("Query", "Data0 ${it.data}")
                item_activity_title.text = itemData!!.title_en
                ratingBar.rating = itemData!!.current_score!!.toFloat()
                score.text = itemData!!.current_score!!.toString()
                shortDec.text = itemData!!.description //Descripcion simple

                val max : Int = itemData!!.max_quantity!!.toInt()
                val myStock : Int? = itemData!!.stock?.toInt()
                val count : MutableList<Int> = mutableListOf()
                if (myStock != null) {
                    if (myStock > max){
                        for (i in 1..max){
                            count.add(i)
                        }
                        amount_spinner.adapter=ArrayAdapter(this,android.R.layout.simple_spinner_dropdown_item,count)
                        amount_spinner.isEnabled = true
                    }else{
                        for (i in 1..myStock){
                            count.add(i)
                        }
                        amount_spinner.adapter=ArrayAdapter(this,android.R.layout.simple_spinner_dropdown_item,count)
                        amount_spinner.isEnabled = true
                    }
                }
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
                    }else{
                        Log.d("Query", "No Data1")
                        images.add("https://firebasestorage.googleapis.com/v0/b/test-udecaldas.appspot.com/o/resorce%2Fimage_not_found.png?alt=media&token=dab5bdb2-11f7-4dd1-b95b-c09caa891373")
                    }
//                    Log.d("Query", "Data1 ${it.data}")
                }else{
                    Log.d("Query", "No Data1")
                    images.add("https://firebasestorage.googleapis.com/v0/b/test-udecaldas.appspot.com/o/resorce%2Fimage_not_found.png?alt=media&token=dab5bdb2-11f7-4dd1-b95b-c09caa891373")
                }
                if (itemData!!.price != null || itemInfo!!.discount != null ){
//                    total_price.text= (itemData!!.price?.minus(itemInfo!!.discount!!)).toString()
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