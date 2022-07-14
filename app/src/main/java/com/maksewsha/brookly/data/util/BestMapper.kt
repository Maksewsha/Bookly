package com.maksewsha.brookly.data.util

import com.maksewsha.brookly.data.model.Best
import com.maksewsha.brookly.data.model.Rate
import com.maksewsha.brookly.data.model.responses.BestFullData
import com.maksewsha.brookly.domain.model.BestDomain
import com.maksewsha.brookly.domain.model.RateDomain
import com.maksewsha.brookly.domain.model.responses.BestFullDomain
import com.maksewsha.brookly.domain.util.EntityMapper

class BestMapper: EntityMapper<BestFullDomain, BestFullData> {
    override fun mapToTo(entity: BestFullData) = when(entity){
        is BestFullData.Success -> {
            BestFullDomain.Success(
                bestList = entity.data.map {
                    BestDomain(
                        id = it.id,
                        title = it.title,
                        author = it.author,
                        price = it.price,
                        image = it.image,
                        rate = RateDomain(
                            score = it.rate?.score,
                            amount = it.rate?.amount
                        )
                    )
                }
            )
        }
        is BestFullData.Fail -> {
            BestFullDomain.Fail(
                errorMessage = entity.errorMessage
            )
        }
    }

    override fun mapToFrom(entity: BestFullDomain) = when(entity){
        is BestFullDomain.Success -> {
            BestFullData.Success(
                data = entity.bestList.map{
                    Best(
                        id = it.id,
                        title = it.title,
                        author = it.author,
                        price = it.price,
                        image = it.image,
                        rate = Rate(
                            score = it.rate?.score,
                            amount = it.rate?.amount
                        )
                    )
                }
            )
        }
        is BestFullDomain.Fail -> {
            BestFullData.Fail(
                errorMessage = entity.errorMessage
            )
        }
    }

}