package com.maksewsha.brookly.presentation.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.AnimationUtils
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import com.maksewsha.brookly.R
import com.maksewsha.brookly.presentation.model.CarouselPresentation

class CarouselAdapter(private val carousel: List<CarouselPresentation>):
    RecyclerView.Adapter<CarouselAdapter.CarouselViewHolder>() {
    class CarouselViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val image = itemView.findViewById<ImageView>(R.id.carousel_image)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CarouselViewHolder {
        return CarouselViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.carousel_card, parent, false))
    }

    override fun onBindViewHolder(holder: CarouselViewHolder, position: Int) {
        Glide.with(holder.itemView.context)
            .load(carousel[position].image)
            .override(300, 450)
            .transform(RoundedCorners(15))
            .centerCrop()
            .into(holder.image)
    }

    override fun getItemCount(): Int {
        return carousel.size
    }
}