package com.maksewsha.brookly.domain.model.responses

import com.maksewsha.brookly.domain.model.CarouselDomain

sealed class CarouselFullDomain {
    class Success(val bestList: List<CarouselDomain>): CarouselFullDomain()
    class Fail(val errorMessage: String): CarouselFullDomain()
}