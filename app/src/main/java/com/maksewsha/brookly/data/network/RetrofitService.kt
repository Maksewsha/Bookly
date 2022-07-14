package com.maksewsha.brookly.data.network

import com.maksewsha.brookly.data.model.*
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create
import retrofit2.http.GET

interface RetrofitService {

    @GET("carousel")
    fun getCarousel(): Call<Carousel>

    @GET("best")
    fun getBest(): Call<Best>

    @GET("similar")
    fun getSimilar(): Call<Similar>



    companion object {
        private val BASE_URL = "https://my-json-server.typicode.com/stellardiver/ebookdata"
        private var retrofitService: RetrofitService? = null

        fun getInstance(): RetrofitService{
            if (retrofitService == null){
                val retrofit = Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build()
                retrofitService = retrofit.create(RetrofitService::class.java)
            }
            return retrofitService!!
        }
    }
}