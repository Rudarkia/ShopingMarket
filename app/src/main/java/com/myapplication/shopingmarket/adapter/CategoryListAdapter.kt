package com.myapplication.shopingmarket.adapter

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import com.myapplication.shopingmarket.ProductFragment
import com.myapplication.shopingmarket.R
import com.myapplication.shopingmarket.dataModel.CategoryEntity
import com.squareup.picasso.Picasso

class CategoryListAdapter(context: AppCompatActivity,
                          private val dataSet: MutableList<CategoryEntity>) : RecyclerView.Adapter<CategoryListAdapter.CategoryViewHolder>() {

    private val context: AppCompatActivity=context

    class CategoryViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){

        val imgViewImage = itemView.findViewById<ImageView>(R.id.category_item_image)
        val texViewTitle = itemView.findViewById<TextView>(R.id.category_item_title)
        val textViewDetails = itemView.findViewById<TextView>(R.id.category_item_details)
        val textId = itemView.findViewById<TextView>(R.id.category_id)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategoryViewHolder {

        return CategoryViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.home_category_item_recycle,parent,false))
    }

    override fun onBindViewHolder(holder: CategoryViewHolder, position: Int) {

        Picasso.get().load(dataSet[position].image).into(holder.imgViewImage) //picasso image tool
        holder.texViewTitle.text = dataSet[position].title_en
        holder.textViewDetails.text = dataSet[position].description
        holder.textId.text = "ID: "+dataSet[position].id //OnlyTest
        holder.textId.visibility = View.INVISIBLE

        val data = Bundle()
        data.putString("id",dataSet[position].id)

        holder.itemView.setOnClickListener{
//            Toast.makeText(holder.itemView.context,dataSet[position].id,Toast.LENGTH_LONG).show()  //OnlyTest
            context.supportFragmentManager.beginTransaction()
                .setReorderingAllowed(true)
                .replace(R.id.product_fragment_view, ProductFragment::class.java,data,"productList")
                .addToBackStack("TagFragmentCategory")
                .commit()
        }

    }

    override fun getItemCount() = dataSet.size
}