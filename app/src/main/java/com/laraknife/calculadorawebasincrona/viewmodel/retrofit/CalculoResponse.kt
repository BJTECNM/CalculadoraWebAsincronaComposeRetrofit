package com.laraknife.calculadorawebasincrona.viewmodel.retrofit

import com.google.gson.annotations.SerializedName

data class CalculoResponse(
    @SerializedName("resultado") val valor:String
)