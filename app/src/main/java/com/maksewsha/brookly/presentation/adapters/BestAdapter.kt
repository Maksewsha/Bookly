package com.maksewsha.brookly.presentation.adapters

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import com.maksewsha.brookly.R
import com.maksewsha.brookly.presentation.fragments.DetailFragment
import com.maksewsha.brookly.presentation.model.BestPresentation

class BestAdapter(private val best: List<BestPresentation>) :
    RecyclerView.Adapter<BestAdapter.BestViewHolder>() {

    class BestViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val title = itemView.findViewById<TextView>(R.id.best_title)
        val author = itemView.findViewById<TextView>(R.id.best_author)
        val price = itemView.findViewById<TextView>(R.id.best_price)
        val score = itemView.findViewById<TextView>(R.id.best_score)
        val votesAmount = itemView.findViewById<TextView>(R.id.best_votes)
        val image = itemView.findViewById<ImageView>(R.id.best_image)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BestViewHolder {
        val itemView =
            LayoutInflater.from(parent.context).inflate(R.layout.best_card, parent, false)
        return BestViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: BestViewHolder, position: Int) {
        holder.title.text = best[position].title
        holder.author.text = best[position].author
        holder.price.text = best[position].price.toString() + " €"
        holder.score.text = best[position].rate?.score.toString()
        holder.votesAmount.text = "(${best[position].rate?.amount.toString()})"

        Glide.with(holder.itemView.context)
            .load(best[position].image)
            .override(200, 300)
            .transform(RoundedCorners(15))
            .centerCrop()
            .into(holder.image)

        holder.itemView.setOnClickListener {
            val bundle = Bundle()
            bundle.putSerializable("book", best[position])

            (holder.itemView.context as AppCompatActivity)
                .supportFragmentManager
                .beginTransaction()
                .replace(R.id.fragment_container_view, DetailFragment::class.java, bundle, "DetailFragment")
                .commit()
        }
    }

    override fun getItemCount(): Int {
        return best.size
    }
}