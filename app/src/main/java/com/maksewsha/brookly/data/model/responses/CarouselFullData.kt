package com.maksewsha.brookly.data.model.responses

import com.maksewsha.brookly.data.model.Carousel

sealed class CarouselFullData {
    class Success(val data: List<Carousel>): CarouselFullData()
    class Fail(val errorMessage: String): CarouselFullData()
}