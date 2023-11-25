package com.laraknife.calculadorawebasincrona.viewmodel.retrofit

import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST

interface ApiService {
    @POST("servicios.php")
    suspend fun getCalculo(
        @Body post: datos
    ): Response<CalculoResponse>
}