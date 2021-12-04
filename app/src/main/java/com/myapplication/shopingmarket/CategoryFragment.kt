package com.myapplication.shopingmarket

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import com.google.firebase.firestore.FirebaseFirestore


class CategoryFragment : Fragment() {

    private  var firestoreDb = FirebaseFirestore.getInstance()
    private lateinit var listCategoryRecyclerView: RecyclerView
    private lateinit var categoryAdapter: RecyclerView.Adapter<CategoryListAdapter.CategoryViewHolder>
    var obList: MutableList<CategoryEntity> = mutableListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        return inflater.inflate(R.layout.fragment_list,container,false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        obList.clear()
        firestoreDb.collection("categories").get().addOnSuccessListener { documents ->
            for (document in documents) {
                obList.add(
                    CategoryEntity(
                        document.id,
                        document.get("image").toString(),
                        document.get("title_en").toString(),
                        document.get("title_es").toString(),
                        document.get("description").toString()
                    )
                )
            }
            categoryAdapter.notifyDataSetChanged()
        }

        listCategoryRecyclerView = requireView().findViewById(R.id.item_view)
        categoryAdapter = CategoryListAdapter(activity as AppCompatActivity, obList)

        listCategoryRecyclerView.setHasFixedSize(true)

        listCategoryRecyclerView.adapter = categoryAdapter
        //listCategoryRecyclerView.addItemDecoration(DividerItemDecoration(context,DividerItemDecoration.VERTICAL))
    }
}