package com.myapplication.shopingmarket

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.widget.ViewPager2

class RecommendAdapter (private val viewPager : ViewPager2, private val sliderList : ArrayList<IntroSlideR>) :
    RecyclerView.Adapter<RecommendAdapter.SliderViewHolder>() {

    inner class SliderViewHolder(var view : View) : RecyclerView.ViewHolder(view){
        val textTitle = view.findViewById<TextView>(R.id.recommend_title)
        val textPrice = view.findViewById<TextView>(R.id.recommend_price)
        val textRating = view.findViewById<TextView>(R.id.recommend_ratings)
        val iconImage = view.findViewById<ImageView>(R.id.recommended_image)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SliderViewHolder {
        return SliderViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.recommend_item,parent,false
            )
        )
    }

    override fun onBindViewHolder(holder: SliderViewHolder, position: Int) {
        val resourceData = sliderList[position]
        holder.iconImage.setImageResource(resourceData.imgIcon)
        if (position == sliderList.size -2){
            viewPager.post(run)
        }
    }
    private val run = Runnable {
        sliderList.addAll(sliderList)
        notifyDataSetChanged()
    }

    override fun getItemCount(): Int = sliderList.size

}