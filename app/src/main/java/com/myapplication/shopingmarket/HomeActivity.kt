package com.myapplication.shopingmarket

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.Toast
import kotlin.concurrent.thread

class HomeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        Thread.sleep(2000)
        setTheme(R.style.Theme_ShopingMarket)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        setSupportActionBar(findViewById(R.id.mainToolbar))
        showToast(1)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.main_menu,menu)
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
            2 ->Toast.makeText(applicationContext,"!Gracias pedaso de animal",Toast.LENGTH_LONG).show()

        }

    }
}