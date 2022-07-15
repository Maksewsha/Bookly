package com.maksewsha.brookly.presentation.util

import com.maksewsha.brookly.domain.model.BestDomain
import com.maksewsha.brookly.domain.model.RateDomain
import com.maksewsha.brookly.domain.model.responses.BestFullDomain
import com.maksewsha.brookly.domain.util.EntityMapper
import com.maksewsha.brookly.presentation.model.BestFullPresentation
import com.maksewsha.brookly.presentation.model.BestPresentation
import com.maksewsha.brookly.presentation.model.RatePresentation

class BestUIMapper : EntityMapper<BestFullPresentation, BestFullDomain> {
    override fun mapToTo(entity: BestFullDomain) = when (entity) {
        is BestFullDomain.Success -> {
            BestFullPresentation.Success(
                data = entity.bestList.map {
                    BestPresentation(
                        it.id,
                        it.title,
                        it.author,
                        it.price,
                        it.image,
                        RatePresentation(it.rate?.score, it.rate?.amount)
                    )
                }
            )
        }
        is BestFullDomain.Fail -> {
            BestFullPresentation.Fail(
                entity.errorMessage
            )
        }
    }

    override fun mapToFrom(entity: BestFullPresentation) = when(entity){
        is BestFullPresentation.Success -> {
            BestFullDomain.Success(
                bestList = entity.data.map {
                    BestDomain(
                        it.id,
                        it.title,
                        it.author,
                        it.price,
                        it.image,
                        RateDomain(
                            it.rate?.score,
                            it.rate?.amount
                        )
                    )
                }
            )
        }
        is BestFullPresentation.Fail -> {
            BestFullDomain.Fail(
                entity.errorMessage
            )
        }
    }
}