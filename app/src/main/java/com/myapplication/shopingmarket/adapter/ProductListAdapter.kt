package com.myapplication.shopingmarket.adapter

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import com.myapplication.shopingmarket.ItemActivity
import com.myapplication.shopingmarket.dataModel.ProductEntity
import com.myapplication.shopingmarket.R
import com.squareup.picasso.Picasso

class ProductListAdapter (
    private var context: AppCompatActivity,
    private val dataSet: MutableList<ProductEntity>) : RecyclerView.Adapter<ProductListAdapter.ProductViewHolder>(){

    class ProductViewHolder(layoutView: View): RecyclerView.ViewHolder(layoutView){

        val imgViewImage = layoutView.findViewById<ImageView>(R.id.item_image)
        val texViewTitle = layoutView.findViewById<TextView>(R.id.item_title)
        val textViewPrice = layoutView.findViewById<TextView>(R.id.item_price)
        val textViewDetails = layoutView.findViewById<TextView>(R.id.item_details)
        val textId = layoutView.findViewById<TextView>(R.id.product_id)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductViewHolder {

        return ProductViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.home_item_recycle,parent,false))
    }

    override fun onBindViewHolder(holder: ProductViewHolder, position: Int) {

        Picasso.get().load(dataSet[position].image).into(holder.imgViewImage) //picasso image tool
        holder.texViewTitle.text = dataSet[position].title_en
        holder.textViewPrice.text = dataSet[position].price.toString()
        holder.textViewDetails.text = dataSet[position].description
        holder.textId.text = "ID: " + dataSet[position].id //OnlyTest

        holder.itemView.setOnClickListener{
//            Toast.makeText(holder.itemView.context,dataSet[position].category,Toast.LENGTH_LONG).show()  //OnlyTest
//            Toast.makeText(holder.itemView.context,dataSet[position].id,Toast.LENGTH_LONG).show()  //OnlyTest
            context.let{
                val intent = Intent (it, ItemActivity::class.java)
                intent.putExtra("Product",dataSet[position].id)
                it.startActivity(intent)
            }
        }

    }

    override fun getItemCount() = dataSet.size

}

