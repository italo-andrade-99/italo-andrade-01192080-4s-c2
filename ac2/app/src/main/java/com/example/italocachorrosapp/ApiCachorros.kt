package com.example.italocachorrosapp

import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path

interface ApiCachorros {

    @POST("cachorros")
    fun post(@Body novoCachorro:Cachorros) : Call<Cachorros>

    @GET("cachorros")
    fun get(): Call<List<Cachorros>>


}