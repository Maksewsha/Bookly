package com.maksewsha.brookly.domain.usecases

import com.maksewsha.brookly.domain.repository.EbookRepository


class GetSimilarUseCase(private val repository: EbookRepository) {
    fun execute() = repository.fetchSimilar()
}