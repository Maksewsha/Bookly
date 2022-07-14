package com.maksewsha.brookly.data.util

import com.maksewsha.brookly.data.model.Similar
import com.maksewsha.brookly.data.model.responses.SimilarFullData
import com.maksewsha.brookly.domain.model.SimilarDomain
import com.maksewsha.brookly.domain.model.responses.SimilarFullDomain
import com.maksewsha.brookly.domain.util.EntityMapper

class SimilarMapper: EntityMapper<SimilarFullDomain, SimilarFullData> {
    override fun mapToTo(entity: SimilarFullData) = when(entity){
        is SimilarFullData.Success -> {
            SimilarFullDomain.Success(
                data = entity.data.map{
                    SimilarDomain(
                        id = it.id,
                        image = it.image
                    )
                }
            )
        }
        is SimilarFullData.Fail -> {
            SimilarFullDomain.Fail(
                errorMessage = entity.errorMessage
            )
        }
    }

    override fun mapToFrom(entity: SimilarFullDomain) = when(entity){
        is SimilarFullDomain.Success -> {
            SimilarFullData.Success(
                data = entity.data.map{
                    Similar(
                        id = it.id,
                        image = it.image
                    )
                }
            )
        }
        is SimilarFullDomain.Fail -> {
            SimilarFullData.Fail(
                errorMessage = entity.errorMessage
            )
        }
    }
}