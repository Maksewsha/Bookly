package com.maksewsha.brookly.presentation.model


data class BestPresentation(
    val id: Int?,
    val title: String?,
    val author: String?,
    val price: Double?,
    val image: String?,
    val rate: RatePresentation?
)