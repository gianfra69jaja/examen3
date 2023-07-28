package com.gire.examen3_gianfranco_remaycuna.repository

import com.gire.examen3_gianfranco_remaycuna.model.PeopleResponse
import com.gire.examen3_gianfranco_remaycuna.model.Person
import com.gire.examen3_gianfranco_remaycuna.service.StarWarsApi
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class StarWarsRepository {
    private val api = Retrofit.Builder()
        .baseUrl("https://swapi.dev/api/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()
        .create(StarWarsApi::class.java)

    suspend fun getPeople(): PeopleResponse? {
        val response = api.getPeople()
        return if (response.isSuccessful) {
            response.body()
        } else {
            null
        }
    }

}
