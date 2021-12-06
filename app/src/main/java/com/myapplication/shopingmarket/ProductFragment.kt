package com.myapplication.shopingmarket

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import com.google.firebase.firestore.FirebaseFirestore
import com.myapplication.shopingmarket.adapter.ProductListAdapter

class ProductFragment : Fragment() {

    private  var firestoreDb = FirebaseFirestore.getInstance()
    private lateinit var listProductRecyclerView: RecyclerView
    private lateinit var productAdapter: RecyclerView.Adapter<ProductListAdapter.ProductViewHolder>
    var obList: MutableList<ProductEntity> = mutableListOf()

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

        val filter: String? = requireArguments().getString("id") //Filter by category

        obList.clear()
//        Toast.makeText(activity,filter.toString(),Toast.LENGTH_LONG).show()  //OnlyTest
        firestoreDb.collection("product")
            .whereEqualTo("category",filter)
            .whereEqualTo("discontinued",false).get().addOnSuccessListener { documents ->
            for (document in documents) {
                obList.add(
                    ProductEntity(
                        document.id,
                        document.get("category").toString(),
                        document.get("discontinued") as Boolean,
                        document.get("image").toString(),
                        document.get("title_en").toString(),
                        document.get("title_es").toString(),
                        document.get("price").toString().toDouble(),
                        document.get("max_quantity").toString().toDouble(),
                        document.get("stock").toString().toDouble(),
                        document.get("current_score").toString().toDouble(),
                        document.get("description").toString()
                    )
                )
            }
            productAdapter.notifyDataSetChanged()
        }

        listProductRecyclerView = requireView().findViewById(R.id.item_view)
        productAdapter = ProductListAdapter(activity as AppCompatActivity, obList)
        listProductRecyclerView.setHasFixedSize(true)
        listProductRecyclerView.adapter = productAdapter
        //listCategoryRecyclerView.addItemDecoration(DividerItemDecoration(context,DividerItemDecoration.VERTICAL))
    }
}