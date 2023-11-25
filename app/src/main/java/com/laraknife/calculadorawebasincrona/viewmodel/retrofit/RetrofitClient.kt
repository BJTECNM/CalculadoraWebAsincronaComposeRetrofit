package com.laraknife.calculadorawebasincrona.viewmodel.retrofit

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create

object RetrofitClient {
    private val retrofit = Retrofit.Builder()
            .baseUrl(Constants.UrlServer)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

    fun getInstance():ApiService{
        return retrofit.create(ApiService::class.java)
    }
}