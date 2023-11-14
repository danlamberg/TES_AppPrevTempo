package com.example.myrestapp

import retrofit2.http.GET

interface ApiService {
    @GET("/alexandrefelipemuller/fakeBackend/main/wheater.json")
    suspend fun getComments(): List<Previsao>
}