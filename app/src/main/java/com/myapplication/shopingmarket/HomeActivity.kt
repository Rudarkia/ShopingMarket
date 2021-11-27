package com.myapplication.shopingmarket

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.viewpager2.widget.ViewPager2


class HomeActivity : AppCompatActivity() {

    private var viewPager2: ViewPager2? = null

    private val introSliderAdapter = RecommendAdapter(
        listOf(
            IntroSlideR(R.mipmap.ic_launcher,"Recommended Item","4.4","$16 USD"),
            IntroSlideR(R.mipmap.ic_launcher,"Recommended Item","4.5","$11 USD"),
            IntroSlideR(R.mipmap.ic_launcher,"Recommended Item","4.3","$14 USD"),
            IntroSlideR(R.mipmap.ic_launcher,"Recommended Item","4.1","$16 USD"),
            IntroSlideR(R.mipmap.ic_launcher,"Recommended Item","4.4","$18 USD"),
            IntroSlideR(R.mipmap.ic_launcher,"Recommended Item","4.2","$17 USD")
        )
    )


    override fun onCreate(savedInstanceState: Bundle?) {

        Thread.sleep(2000)
        setTheme(R.style.Theme_ShopingMarket)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        setSupportActionBar(findViewById(R.id.mainToolbar))

        viewPager2 = findViewById<ViewPager2>(R.id.introSliderViewPager)




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

    private fun showToast(int: Int){
        when (int){
            1 ->Toast.makeText(applicationContext,R.string.noLogin,Toast.LENGTH_LONG).show()
            2 ->Toast.makeText(applicationContext,"!Gracias pedazo de animal",Toast.LENGTH_LONG).show()

        }

    }
}