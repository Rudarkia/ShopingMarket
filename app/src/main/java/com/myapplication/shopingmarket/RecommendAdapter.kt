package com.myapplication.shopingmarket



import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class RecommendAdapter(private val introSlide: List<IntroSlideR>) :
    RecyclerView.Adapter<RecommendAdapter.IntroSlideRAViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): IntroSlideRAViewHolder {
        return IntroSlideRAViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.item_recommend,
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: IntroSlideRAViewHolder, position: Int) {
        holder.bind(introSlide[position])
    }

    override fun getItemCount(): Int {
        return introSlide.size
    }

    inner class IntroSlideRAViewHolder(var view:View): RecyclerView.ViewHolder(view){

        private val textTitle = view.findViewById<TextView>(R.id.recommend_title)
        private val textPrice = view.findViewById<TextView>(R.id.recommend_price)
        private val textRating = view.findViewById<TextView>(R.id.recommend_ratings)
        private val iconImage = view.findViewById<ImageView>(R.id.recommended_image)

        fun bind(introSlide : IntroSlideR){
            textTitle.text = introSlide.title
            textPrice.text = introSlide.price
            textRating.text = introSlide.rating
            iconImage.setImageResource(introSlide.imgIcon)
        }
    }

//
//    override fun getItemCount(): Int = recList.size
//
//    override fun onBindViewHolder(holder: SliderViewHolder, position: Int) {
//        val listImg = recList[position]
//        holder.imgValue.setImageResource(listImg.img)
//        if(position==recList.size -2) {
//            viewPager.post(run)
//        }
//    }
//    private val run = Runnable {
//        recList.addAll(recList)
//        notifyDataSetChanged()
//    }




}