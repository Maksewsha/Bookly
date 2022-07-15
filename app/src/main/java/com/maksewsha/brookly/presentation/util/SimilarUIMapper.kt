package com.maksewsha.brookly.presentation.util

import com.maksewsha.brookly.domain.model.SimilarDomain
import com.maksewsha.brookly.domain.model.responses.SimilarFullDomain
import com.maksewsha.brookly.domain.util.EntityMapper
import com.maksewsha.brookly.presentation.model.SimilarFullPresentation
import com.maksewsha.brookly.presentation.model.SimilarPresentation

class SimilarUIMapper: EntityMapper<SimilarFullPresentation, SimilarFullDomain> {
    override fun mapToTo(entity: SimilarFullDomain) = when(entity){
        is SimilarFullDomain.Success -> {
            SimilarFullPresentation.Success(
                data = entity.data.map{
                    SimilarPresentation(
                        it.id,
                        it.image
                    )
                }
            )
        }
        is SimilarFullDomain.Fail -> {
            SimilarFullPresentation.Fail(
                errorMessage = entity.errorMessage
            )
        }
    }

    override fun mapToFrom(entity: SimilarFullPresentation) = when(entity){
        is SimilarFullPresentation.Success -> {
            SimilarFullDomain.Success(
                data = entity.data.map{
                    SimilarDomain(
                        it.id,
                        it.image
                    )
                }
            )
        }
        is SimilarFullPresentation.Fail -> {
            SimilarFullDomain.Fail(
                errorMessage = entity.errorMessage
            )
        }
    }
}