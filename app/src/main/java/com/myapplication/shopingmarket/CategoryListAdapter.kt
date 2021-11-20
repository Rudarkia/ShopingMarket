package com.myapplication.shopingmarket

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView

class CategoryListAdapter(context: AppCompatActivity,
                          info:Bundle) : RecyclerView.Adapter<CategoryListAdapter.CategoryViewHolder>() {
    class CategoryViewHolder(val layout: View):RecyclerView.ViewHolder(layout)

    private val context: AppCompatActivity=context

    var itemImage: ArrayList<Int> = info.getIntegerArrayList("images") as ArrayList<Int>
    var itemTitle: ArrayList<String> = info.getStringArrayList("titles") as ArrayList<String>
    var itemDetails: ArrayList<String> = info.getStringArrayList("details") as ArrayList<String>

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategoryViewHolder {
        val layout = LayoutInflater.from(parent.context).inflate(R.layout.home_category_item_recycle,parent,false)
        return CategoryViewHolder(layout)
    }

    override fun onBindViewHolder(holder: CategoryViewHolder, position: Int) {

        var imgViewImage = holder.layout.findViewById<ImageView>(R.id.category_item_image)
        imgViewImage.setImageResource(itemImage[position])

        var texViewTitle = holder.layout.findViewById<TextView>(R.id.category_item_title)
        texViewTitle.text = itemTitle[position]

        var  textViewDetails = holder.layout.findViewById<TextView>(R.id.category_item_details)
        textViewDetails.text = itemDetails[position]

        holder.layout.setOnClickListener{

        }
    }

    override fun getItemCount(): Int {
        return itemTitle.size
    }
}