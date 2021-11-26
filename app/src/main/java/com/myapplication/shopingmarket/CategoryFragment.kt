package com.myapplication.shopingmarket

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView

class CategoryFragment : Fragment() {

    private lateinit var listCategoryRecyclerView: RecyclerView
    private lateinit var categoryAdapter: RecyclerView.Adapter<CategoryListAdapter.CategoryViewHolder>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val fragment: View = inflater.inflate(R.layout.fragment_category,container,false)

        return fragment
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        var itemImage: ArrayList<Int> = ArrayList()
        var itemMeTitles: ArrayList<String> = ArrayList()
        var itemDesc: ArrayList<String> = ArrayList()


        for (i in 1..5) {
            itemImage.add(R.drawable.ic_launcher_background)
            itemMeTitles.add(resources.getString(R.string.category_title))
            itemDesc.add(resources.getString(R.string.category_details))
        }

        var obList: Bundle = Bundle()
        obList.putIntegerArrayList("images",itemImage)
        obList.putStringArrayList("titles",itemMeTitles)
        obList.putStringArrayList("details",itemDesc)

        listCategoryRecyclerView = requireView().findViewById<RecyclerView>(R.id.category_view)
        categoryAdapter = CategoryListAdapter(activity as AppCompatActivity,obList)

        listCategoryRecyclerView.setHasFixedSize(false)
        listCategoryRecyclerView.adapter=categoryAdapter
        //listCategoryRecyclerView.addItemDecoration(DividerItemDecoration(context,DividerItemDecoration.VERTICAL))
    }
}