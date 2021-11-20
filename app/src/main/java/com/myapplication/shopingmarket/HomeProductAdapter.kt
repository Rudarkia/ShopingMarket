package com.myapplication.shopingmarket

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView


class HomeProductAdapter (context: AppCompatActivity, val info: Bundle) : RecyclerView.Adapter<HomeProductAdapter.HomeViewHolder>(){
    class HomeViewHolder(val layout: View): RecyclerView.ViewHolder(layout)

    private var context: AppCompatActivity=context

    var itemImage: ArrayList<Int> = info.getIntegerArrayList("images") as ArrayList<Int>
    var itemTitle: ArrayList<String> = info.getStringArrayList("titles") as ArrayList<String>
    var itemPrice: ArrayList<String> = info.getStringArrayList("prices") as ArrayList<String>
    var itemDetails: ArrayList<String> = info.getStringArrayList("details") as ArrayList<String>

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HomeViewHolder {
        val layout = LayoutInflater.from(parent.context).inflate(R.layout.home_item_recycle,parent,false)

        return HomeViewHolder(layout)
    }

    override fun onBindViewHolder(holder: HomeViewHolder, position: Int) {

        var imgViewImage = holder.layout.findViewById<ImageView>(R.id.item_image)
        imgViewImage.setImageResource(itemImage[position])

        var texViewTitle = holder.layout.findViewById<TextView>(R.id.item_title)
        texViewTitle.text = itemTitle[position]

        var  textViewPrice = holder.layout.findViewById<TextView>(R.id.item_price)
        textViewPrice.text = itemPrice[position]

        var  textViewDetails = holder.layout.findViewById<TextView>(R.id.item_details)
        textViewDetails.text = itemDetails[position]

        holder.layout.setOnClickListener{

        }
    }

    override fun getItemCount(): Int {
        return itemTitle.size
    }
}


/*
class HomeMenuAdapter: RecyclerView.Adapter<HomeMenuAdapter.ViewHolder>() {

    override fun onCreateViewHolder(viewGroup: ViewGroup, i: Int): ViewHolder {
        val v = LayoutInflater.from(viewGroup.context).inflate(R.layout.home_item_recycle,viewGroup,false)
        return ViewHolder(v)
    }

    override fun onBindViewHolder(viewHolder: ViewHolder, i: Int) {
        viewHolder.itemImage.setImageResource(images[i])
        viewHolder.itemTitle.text = titles[i]
        viewHolder.itemPrize.text = prize[i]
        viewHolder.itemDatails.text = details[i]
    }

    inner class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        var itemImage: ImageView
        var itemTitle: TextView
        var itemPrize: TextView
        var itemDatails: TextView

        init {
            itemImage = itemView.findViewById(R.id.item_image)
            itemTitle = itemView.findViewById(R.id.item_title)
            itemPrize = itemView.findViewById(R.id.item_prize)
            itemDatails = itemView.findViewById(R.id.item_details)
    }
    }
}*/
