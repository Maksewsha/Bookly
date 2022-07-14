package com.maksewsha.brookly.data.util

import com.maksewsha.brookly.data.model.Carousel
import com.maksewsha.brookly.data.model.responses.CarouselFullData
import com.maksewsha.brookly.domain.model.CarouselDomain
import com.maksewsha.brookly.domain.model.responses.CarouselFullDomain
import com.maksewsha.brookly.domain.util.EntityMapper

class CarouselMapper: EntityMapper<CarouselFullDomain, CarouselFullData> {
    override fun mapToTo(entity: CarouselFullData) = when(entity){
        is CarouselFullData.Success -> {
            CarouselFullDomain.Success(
                bestList = entity.data.map{
                    CarouselDomain(
                        id = it.id,
                        image = it.image
                    )
                }
            )
        }
        is CarouselFullData.Fail -> {
            CarouselFullDomain.Fail(
                errorMessage = entity.errorMessage
            )
        }
    }

    override fun mapToFrom(entity: CarouselFullDomain) = when(entity){
        is CarouselFullDomain.Success -> {
            CarouselFullData.Success(
                data = entity.bestList.map{
                    Carousel(
                        id = it.id,
                        image = it.image
                    )
                }
            )
        }
        is CarouselFullDomain.Fail -> {
            CarouselFullData.Fail(
                errorMessage = entity.errorMessage
            )
        }
    }
}