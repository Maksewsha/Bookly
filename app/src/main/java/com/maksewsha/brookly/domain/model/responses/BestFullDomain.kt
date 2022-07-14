package com.maksewsha.brookly.domain.model.responses

import com.maksewsha.brookly.domain.model.BestDomain

sealed class BestFullDomain{
    class Success(val bestList: List<BestDomain>): BestFullDomain()
    class Fail(val errorMessage: String): BestFullDomain()
}
