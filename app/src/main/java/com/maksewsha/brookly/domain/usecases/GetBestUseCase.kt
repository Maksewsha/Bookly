package com.maksewsha.brookly.domain.usecases

import com.maksewsha.brookly.domain.model.responses.BestFullDomain
import com.maksewsha.brookly.domain.repository.EbookRepository

class GetBestUseCase(private val repository: EbookRepository) {
    fun execute() = repository.fetchBest()
}