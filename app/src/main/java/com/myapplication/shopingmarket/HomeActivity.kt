package com.myapplication.shopingmarket


import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.widget.CompositePageTransformer
import androidx.viewpager2.widget.MarginPageTransformer
import androidx.viewpager2.widget.ViewPager2
import com.google.firebase.analytics.FirebaseAnalytics
import kotlinx.android.synthetic.main.activity_home.*
import kotlin.math.abs

class HomeActivity : AppCompatActivity() {

    /*** Slider Recommend Var***/
    private lateinit var sliderItemList: ArrayList<IntroSlideR>
    private lateinit var recommendAdapter: RecommendAdapter
    private lateinit var sliderHandler: Handler
    private lateinit var sliderRun: Runnable
    /*** Slider Recommend Var***/

    override fun onCreate(savedInstanceState: Bundle?) {
        //Splash
        Thread.sleep(2000)
        setTheme(R.style.Theme_ShopingMarket)

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        val analiyticBundle = Bundle()
        val analytics: FirebaseAnalytics = FirebaseAnalytics.getInstance(this)
        analiyticBundle.putString("message","HomeActivity")
        analytics.logEvent("InitScreen",analiyticBundle)
        //Tool bar
        setSupportActionBar(findViewById(R.id.mainToolbar))
        ///Recommend Slider
        sliderItems()
        itemSliderView()

        showToast(1)

        if (savedInstanceState == null){
            supportFragmentManager.beginTransaction()
                .setReorderingAllowed(true)
                .add(R.id.product_fragment_view, CategoryFragment::class.java,null,"TagFragmentCategory")
                .commit()
        }
    }

    /***  Slider Recommend ***/

    private fun sliderItems() {
        sliderItemList = ArrayList()
        recommendAdapter = RecommendAdapter(recommendSlider,sliderItemList)
        recommendSlider.adapter=recommendAdapter
        recommendSlider.clipToPadding=false
        recommendSlider.clipChildren=false
        recommendSlider.offscreenPageLimit=3
        recommendSlider.getChildAt(0).overScrollMode=RecyclerView.OVER_SCROLL_NEVER

        val comPosPageTarn = CompositePageTransformer()
        comPosPageTarn.addTransformer(MarginPageTransformer(40))
        comPosPageTarn.addTransformer { page,position ->
            val r : Float = 1 - abs(position)
            page.scaleY = 0.85f + r * 0.15f
        }
        recommendSlider.setPageTransformer(comPosPageTarn)
        sliderHandler= Handler()
        sliderRun = Runnable {
            recommendSlider.currentItem = recommendSlider.currentItem + 1
        }
        recommendSlider.registerOnPageChangeCallback(
            object : ViewPager2.OnPageChangeCallback(){
                override fun onPageSelected(position: Int) {
                    super.onPageSelected(position)
                    sliderHandler.removeCallbacks(sliderRun)
                    sliderHandler.postDelayed(sliderRun,2000)
                }
            }
        )

    }

    override fun onPause() {
        super.onPause()
        sliderHandler.removeCallbacks(sliderRun)
    }

    override fun onResume() {
        super.onResume()
        sliderHandler.postDelayed(sliderRun,2000)
    }

    //Add items
    private fun itemSliderView() {
        sliderItemList.add(IntroSlideR(R.mipmap.ic_launcher))
        sliderItemList.add(IntroSlideR(R.mipmap.ic_launcher))
        sliderItemList.add(IntroSlideR(R.mipmap.ic_launcher))
        sliderItemList.add(IntroSlideR(R.mipmap.ic_launcher))
        sliderItemList.add(IntroSlideR(R.mipmap.ic_launcher))
        sliderItemList.add(IntroSlideR(R.mipmap.ic_launcher))
        sliderItemList.add(IntroSlideR(R.mipmap.ic_launcher))
        sliderItemList.add(IntroSlideR(R.mipmap.ic_launcher))

    }
    /***  Slider Recommend ***/

    /***  Toolbar ***/
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