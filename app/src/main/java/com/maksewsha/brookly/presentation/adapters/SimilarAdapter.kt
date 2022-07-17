package com.maksewsha.brookly.presentation.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import com.maksewsha.brookly.R
import com.maksewsha.brookly.presentation.model.SimilarPresentation

class SimilarAdapter(private val similars: List<SimilarPresentation>) :
    RecyclerView.Adapter<SimilarAdapter.SimilarViewHolder>() {
    class SimilarViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val image = itemView.findViewById<ImageView>(R.id.similar_image)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SimilarViewHolder {
        return SimilarViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.similar_card, parent, false))
    }

    override fun onBindViewHolder(holder: SimilarViewHolder, position: Int) {
        Glide.with(holder.itemView.context)
            .load(similars.get(position).image)
            .override(200, 300)
            .transform(RoundedCorners(25))
            .into(holder.image)
    }

    override fun getItemCount(): Int {
        return similars.size
    }
}