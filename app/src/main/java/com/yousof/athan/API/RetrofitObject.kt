package com.yousof.athan.API

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create

object RetrofitObject {


    val BASE_URL = "https://api.aladhan.com/v1"

    val athanApi: AthanApi by lazy {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(AthanApi ::class.java)

    }
}

