package com.maksewsha.brookly.domain.util

interface EntityMapper<T, F> {
    fun mapToTo(entity: F): T
    fun mapToFrom(entity: T): F
}