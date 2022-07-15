package com.maksewsha.brookly.presentation.viewmodels.factories

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.maksewsha.brookly.data.network.RetrofitService
import com.maksewsha.brookly.data.repository.NetworkRepository
import com.maksewsha.brookly.domain.usecases.GetBestUseCase
import com.maksewsha.brookly.domain.usecases.GetCarouselUseCase
import com.maksewsha.brookly.domain.usecases.GetSimilarUseCase
import com.maksewsha.brookly.presentation.viewmodels.MainViewModel

class MainVMFactory: ViewModelProvider.Factory {

    private val retrofitService by lazy {
        RetrofitService.getInstance()
    }

    private val repository by lazy{
        NetworkRepository(retrofitService)
    }

    private val getBestUseCase by lazy {
        GetBestUseCase(repository)
    }

    private val getSimilarUseCase by lazy {
        GetSimilarUseCase(repository)
    }

    private val getCarouselUseCase by lazy {
        GetCarouselUseCase(repository)
    }

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return MainViewModel(getBestUseCase, getCarouselUseCase, getSimilarUseCase) as T
    }
}