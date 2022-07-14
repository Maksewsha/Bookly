package com.maksewsha.brookly.domain.model.responses

import com.maksewsha.brookly.domain.model.SimilarDomain

sealed class SimilarFullDomain {
    class Success(val data: List<SimilarDomain>): SimilarFullDomain()
    class Fail(val errorMessage: String): SimilarFullDomain()
}