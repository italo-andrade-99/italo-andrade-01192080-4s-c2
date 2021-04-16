package com.example.italocachorrosapp

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object ConexaoCachorros {

    fun criar(): ApiCachorros {

        // recuperamos, por meio do Retrofit, a implementação da interface com os EndPoints
        return Retrofit.Builder()
            .baseUrl("https://5f861cfdc8a16a0016e6aacd.mockapi.io/bandtec-api/") // URL Base da API
            .addConverterFactory(GsonConverterFactory.create()) // quem será o "conversor" JSON <=> Classe
            .build()
            .create(ApiCachorros::class.java)
    }

}