package com.maksewsha.brookly.domain.model

data class BestDomain(
    val id: Int?,
    val title: String?,
    val author: String?,
    val price: Double?,
    val image: String?,
    val rate: RateDomain?
)