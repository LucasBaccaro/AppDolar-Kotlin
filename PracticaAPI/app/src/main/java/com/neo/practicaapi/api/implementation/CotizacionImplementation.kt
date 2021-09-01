package com.neo.practicaapi.api.implementation

import com.neo.practicaapi.api.ApiCotizacion
import com.neo.practicaapi.model.Moneda
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class CotizacionImplementation{

    private fun getRetrofit():Retrofit{
        return Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl("https://api.bluelytics.com.ar/")
            .build()
    }

    fun funGetCotizacion():Call<Moneda>{
        return getRetrofit().create(ApiCotizacion::class.java).getMoneda()
    }
}