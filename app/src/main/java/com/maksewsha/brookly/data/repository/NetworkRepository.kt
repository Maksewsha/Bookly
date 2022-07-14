package com.maksewsha.brookly.data.repository

import com.maksewsha.brookly.data.model.Best
import com.maksewsha.brookly.data.model.Carousel
import com.maksewsha.brookly.data.model.Similar
import com.maksewsha.brookly.data.model.responses.BestFullData
import com.maksewsha.brookly.data.model.responses.CarouselFullData
import com.maksewsha.brookly.data.model.responses.SimilarFullData
import com.maksewsha.brookly.data.network.RetrofitService
import com.maksewsha.brookly.data.util.BestMapper
import com.maksewsha.brookly.data.util.CarouselMapper
import com.maksewsha.brookly.data.util.SimilarMapper
import com.maksewsha.brookly.domain.model.responses.BestFullDomain
import com.maksewsha.brookly.domain.model.responses.CarouselFullDomain
import com.maksewsha.brookly.domain.model.responses.SimilarFullDomain
import com.maksewsha.brookly.domain.repository.EbookRepository

class NetworkRepository constructor(private val retrofit: RetrofitService): EbookRepository {

    private val bestMapper = BestMapper()
    private val carouselMapper = CarouselMapper()
    private val similarMapper = SimilarMapper()

    override fun fetchCarousel(): CarouselFullDomain {
        val response = retrofit.getCarousel()
        val result = response.execute()
        return if(result.isSuccessful){
            carouselMapper.mapToTo(CarouselFullData.Success(result.body() as List<Carousel>))
        } else {
            carouselMapper.mapToTo(CarouselFullData.Fail(result.message()))
        }
    }

    override fun fetchBest(): BestFullDomain {
        val response = retrofit.getBest()
        val result = response.execute()
        return if(result.isSuccessful){
            bestMapper.mapToTo(BestFullData.Success(result.body() as List<Best>))
        } else {
            bestMapper.mapToTo(BestFullData.Fail(result.message()))
        }
    }

    override fun fetchSimilar(): SimilarFullDomain {
        val response = retrofit.getSimilar()
        val result = response.execute()
        return if (result.isSuccessful){
            similarMapper.mapToTo(SimilarFullData.Success(result.body() as List<Similar>))
        } else {
            similarMapper.mapToTo(SimilarFullData.Fail(result.message()))
        }
    }
}