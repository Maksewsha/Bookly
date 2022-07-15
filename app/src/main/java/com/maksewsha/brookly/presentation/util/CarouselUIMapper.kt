package com.maksewsha.brookly.presentation.util

import com.maksewsha.brookly.domain.model.CarouselDomain
import com.maksewsha.brookly.domain.model.responses.CarouselFullDomain
import com.maksewsha.brookly.domain.util.EntityMapper
import com.maksewsha.brookly.presentation.model.CarouselFullPresentation
import com.maksewsha.brookly.presentation.model.CarouselPresentation

class CarouselUIMapper: EntityMapper<CarouselFullPresentation, CarouselFullDomain> {
    override fun mapToTo(entity: CarouselFullDomain) = when(entity){
        is CarouselFullDomain.Success -> {
            CarouselFullPresentation.Success(
                data = entity.bestList.map {
                    CarouselPresentation(
                        it.id,
                        it.image
                    )
                }
            )
        }
        is CarouselFullDomain.Fail -> {
            CarouselFullPresentation.Fail(
                errorMessage = entity.errorMessage
            )
        }
    }

    override fun mapToFrom(entity: CarouselFullPresentation) = when(entity){
        is CarouselFullPresentation.Success -> {
            CarouselFullDomain.Success(
                bestList = entity.data.map{
                    CarouselDomain(
                        it.id,
                        it.image
                    )
                }
            )
        }
        is CarouselFullPresentation.Fail -> {
            CarouselFullDomain.Fail(
                entity.errorMessage
            )
        }
    }
}