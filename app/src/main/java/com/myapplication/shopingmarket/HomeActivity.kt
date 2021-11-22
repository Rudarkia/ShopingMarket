package com.myapplication.shopingmarket

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView

class HomeActivity : AppCompatActivity() {

    /*private lateinit var listItemRecyclerView: RecyclerView
    private lateinit var productListAdapter: RecyclerView.Adapter<HomeProductAdapter.HomeViewHolder>*/

    override fun onCreate(savedInstanceState: Bundle?) {

        /*var itemImage: ArrayList<Int> = ArrayList()
        var itemMeTitles: ArrayList<String> = ArrayList()
        var itemPrice: ArrayList<String> = ArrayList()
        var itemDesc: ArrayList<String> = ArrayList()


        for (i in 1..5) {
            itemImage.add(R.drawable.ic_launcher_background)
            itemMeTitles.add(resources.getString(R.string.menu_title))
            itemPrice.add(resources.getString(R.string.menu_price))
            itemDesc.add(resources.getString(R.string.menu_details))
        }

        var obList: Bundle = Bundle()
        obList.putIntegerArrayList("images",itemImage)
        obList.putStringArrayList("titles",itemMeTitles)
        obList.putStringArrayList("prices",itemPrice)
        obList.putStringArrayList("details",itemDesc)

        listItemRecyclerView = findViewById<RecyclerView>(R.id.home_recycler)
        menuListAdapter = HomeMenuAdapter(activity as AppCompatActivity,obList)*/


        Thread.sleep(2000)
        setTheme(R.style.Theme_ShopingMarket)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        setSupportActionBar(findViewById(R.id.mainToolbar))

        if (savedInstanceState == null){
            supportFragmentManager.beginTransaction()
                .setReorderingAllowed(true)
                .add(R.id.product_fragment_view, CategoryFragment::class.java,null,"TagFragmentCategory")
                .commit()
            showToast(1)
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.main_menu_no_log,menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem) = when(item.itemId) {
        R.id.action_search ->{
            true
        }
        R.id.login_btn ->{
            val intent = Intent(this,LoginActivity::class.java)
            startActivity(intent)
            true
        }
        else ->{
            super.onOptionsItemSelected(item)
        }

    }

    fun showToast(int: Int){
        when (int){
            1 ->Toast.makeText(applicationContext,R.string.noLogin,Toast.LENGTH_LONG).show()
            2 ->Toast.makeText(applicationContext,"!Gracias pedazo de animal",Toast.LENGTH_LONG).show()

        }

    }
}