package com.maksewsha.brookly.presentation.model

sealed class BestFullPresentation {
    class Success(val data: List<BestPresentation>): BestFullPresentation()
    class Fail(val errorMessage: String): BestFullPresentation()
}