package com.yousof.athan.API

import retrofit2.http.GET
import retrofit2.http.Query

interface AthanApi {

    @GET("/v1/current.json")
    suspend fun getAthan(
        @Query ("q") city: String,

    )
}