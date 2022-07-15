package com.maksewsha.brookly.presentation.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.maksewsha.brookly.domain.usecases.GetBestUseCase
import com.maksewsha.brookly.domain.usecases.GetCarouselUseCase
import com.maksewsha.brookly.domain.usecases.GetSimilarUseCase
import com.maksewsha.brookly.presentation.model.*
import com.maksewsha.brookly.presentation.util.BestUIMapper
import com.maksewsha.brookly.presentation.util.CarouselUIMapper
import com.maksewsha.brookly.presentation.util.SimilarUIMapper
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainViewModel(
    private val getBestUseCase: GetBestUseCase,
    private val getCarouselUseCase: GetCarouselUseCase,
    private val getSimilarUseCase: GetSimilarUseCase
) : ViewModel() {
    private val _bestList = MutableLiveData<List<BestPresentation>>()
    val bestList = _bestList as LiveData<List<BestPresentation>>

    private val _errorMessageBest = MutableLiveData<String>()
    val errorMessageBest = _errorMessageBest as LiveData<String>

    private val _carouselList = MutableLiveData<List<CarouselPresentation>>()
    val carouselList = _carouselList as LiveData<List<CarouselPresentation>>

    private val _errorMessageCarousel = MutableLiveData<String>()
    val errorMessageCarousel = _errorMessageCarousel as LiveData<String>

    private val _similarList = MutableLiveData<List<SimilarPresentation>>()
    val similarList = _similarList as LiveData<List<SimilarPresentation>>

    private val _errorMessageSimilar = MutableLiveData<String>()
    val errorMessageSimilar = _errorMessageSimilar as LiveData<String>

    private val bestUIMapper = BestUIMapper()
    private val carouselUIMapper = CarouselUIMapper()
    private val similarUIMapper = SimilarUIMapper()

    fun fetchBestList(){
        CoroutineScope(Dispatchers.IO).launch {
            when(val response = bestUIMapper.mapToTo(getBestUseCase.execute())){
                is BestFullPresentation.Success -> {
                    _bestList.postValue(response.data)
                }
                is BestFullPresentation.Fail -> {
                    _errorMessageBest.postValue(response.errorMessage)
                }
            }
        }
    }

    fun fetchCarousel(){
        CoroutineScope(Dispatchers.IO).launch {
            when(val response = carouselUIMapper.mapToTo(getCarouselUseCase.execute())){
                is CarouselFullPresentation.Success -> {
                    _carouselList.postValue(response.data)
                }
                is CarouselFullPresentation.Fail -> {
                    _errorMessageCarousel.postValue(response.errorMessage)
                }
            }
        }
    }

    fun fetchSimilar(){
        CoroutineScope(Dispatchers.IO).launch {
            when(val response = similarUIMapper.mapToTo(getSimilarUseCase.execute())){
                is SimilarFullPresentation.Success -> {
                    _similarList.postValue(response.data)
                }
                is SimilarFullPresentation.Fail -> {
                    _errorMessageSimilar.postValue(response.errorMessage)
                }
            }
        }
    }
}