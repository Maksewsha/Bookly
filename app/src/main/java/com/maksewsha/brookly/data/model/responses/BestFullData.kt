package com.maksewsha.brookly.data.model.responses

import com.maksewsha.brookly.data.model.Best

sealed class BestFullData {
    class Success(val data: List<Best>): BestFullData()
    class Fail(val errorMessage: String): BestFullData()
}