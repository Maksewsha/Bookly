package com.maksewsha.brookly.data.model.responses

import com.maksewsha.brookly.data.model.Similar

sealed class SimilarFullData {
    class Success(val data: List<Similar>): SimilarFullData()
    class Fail(val errorMessage: String): SimilarFullData()
}