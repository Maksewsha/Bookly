package com.maksewsha.brookly.presentation.model

sealed class SimilarFullPresentation {
    class Success(val data: List<SimilarPresentation>): SimilarFullPresentation()
    class Fail(val errorMessage: String): SimilarFullPresentation()
}