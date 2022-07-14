package com.maksewsha.brookly.domain.repository

import com.maksewsha.brookly.domain.model.responses.BestFullDomain
import com.maksewsha.brookly.domain.model.responses.CarouselFullDomain
import com.maksewsha.brookly.domain.model.responses.SimilarFullDomain

interface EbookRepository {
    fun fetchCarousel(): CarouselFullDomain
    fun fetchBest(): BestFullDomain
    fun fetchSimilar(): SimilarFullDomain
}