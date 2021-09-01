package com.neo.practicaapi.api

import com.neo.practicaapi.model.Moneda
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiCotizacion {

    @GET("v2/latest")
    fun getMoneda():Call<Moneda>
}