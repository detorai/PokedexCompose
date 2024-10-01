package com.example.profiki.Data

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object PokeService {
    val interceptor = HttpLoggingInterceptor().apply { level = HttpLoggingInterceptor.Level.BODY }

    val client = OkHttpClient.Builder().addInterceptor(interceptor).build()
    val retrofit = Retrofit.Builder()
        .baseUrl("https://pokeapi.co/")
        .client(client)
        .addConverterFactory(GsonConverterFactory.create())
        .build()
    val service = retrofit.create(PokeApi::class.java)
}