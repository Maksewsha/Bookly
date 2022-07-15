package com.maksewsha.brookly.presentation.model

import java.io.Serializable


data class BestPresentation(
    val id: Int?,
    val title: String?,
    val author: String?,
    val price: Double?,
    val image: String?,
    val rate: RatePresentation?
) : Serializable