package com.yousof.athan.api

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitObject {
    private val retrofit =
        Retrofit.Builder()
            .baseUrl("https://api.aladhan.com/v1/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

    val aladanApi: AladhanApi = retrofit.create(AladhanApi::class.java)
}
