package com.maksewsha.brookly.presentation.model

sealed class CarouselFullPresentation {
    class Success(val data: List<CarouselPresentation>): CarouselFullPresentation()
    class Fail(val errorMessage: String): CarouselFullPresentation()
}