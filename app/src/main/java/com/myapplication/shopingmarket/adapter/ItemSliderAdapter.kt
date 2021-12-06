package com.myapplication.shopingmarket.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.myapplication.shopingmarket.R
import com.squareup.picasso.Picasso

class ItemSliderAdapter(private val imageList: ArrayList<String>) : RecyclerView.Adapter<ItemSliderAdapter.SliderViewHolder>() {
    class SliderViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val Image = itemView.findViewById<ImageView>(R.id.Item_imageView)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SliderViewHolder {
        return SliderViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.image_item,parent,false
            )
        )
    }

    override fun onBindViewHolder(holder: SliderViewHolder, position: Int) {
        Picasso.get().load(imageList[position]).into(holder.Image)
    }

    override fun getItemCount(): Int = imageList.size
}