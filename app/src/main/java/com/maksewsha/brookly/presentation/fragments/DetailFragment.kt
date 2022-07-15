package com.maksewsha.brookly.presentation.fragments

import android.os.Bundle
import android.view.RoundedCorner
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.DecodeFormat
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import com.bumptech.glide.request.RequestOptions
import com.maksewsha.brookly.R
import com.maksewsha.brookly.presentation.adapters.CarouselAdapter
import com.maksewsha.brookly.presentation.adapters.SimilarAdapter
import com.maksewsha.brookly.presentation.model.BestPresentation
import com.maksewsha.brookly.presentation.model.SimilarPresentation
import com.maksewsha.brookly.presentation.viewmodels.MainViewModel

class DetailFragment: Fragment(R.layout.detail_fragment) {
    private lateinit var fullBookInfo: BestPresentation

    private lateinit var imageDetail: ImageView
    private lateinit var titleDetail: TextView
    private lateinit var authorDetail: TextView
    private lateinit var priceDetail: TextView
    private lateinit var scoreDetail: TextView
    private lateinit var votesDetail: TextView
    private lateinit var similarDetail: RecyclerView

    private val mainViewModel by activityViewModels<MainViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        if (arguments != null){
            fullBookInfo = requireArguments().getSerializable("book") as BestPresentation
        }
        mainViewModel.fetchSimilar()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {


        //This easier be done with binding, but i made it using findViewById
        imageDetail = view.findViewById(R.id.detail_image)
        titleDetail = view.findViewById(R.id.title_detail)
        authorDetail = view.findViewById(R.id.author_detail)
        priceDetail = view.findViewById(R.id.price_detail)
        scoreDetail = view.findViewById(R.id.score_detail)
        votesDetail = view.findViewById(R.id.votes_detail)
        similarDetail = view.findViewById(R.id.similar_detail)

        Glide.with(requireContext())
            .load(fullBookInfo.image)
            .fitCenter()
            .apply(RequestOptions.bitmapTransform(RoundedCorners(50)))
            .into(imageDetail)

        titleDetail.text = fullBookInfo.title
        authorDetail.text = fullBookInfo.author
        priceDetail.text = "${fullBookInfo.price.toString()}€"
        scoreDetail.text = fullBookInfo.rate?.score.toString()
        votesDetail.text = "(${fullBookInfo.rate?.amount})"

        similarDetail.layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
        mainViewModel.similarList.observe(viewLifecycleOwner, object: Observer<List<SimilarPresentation>>{
            override fun onChanged(t: List<SimilarPresentation>?) {
                similarDetail.adapter = SimilarAdapter(t!!)
            }
        })


        super.onViewCreated(view, savedInstanceState)
    }
}