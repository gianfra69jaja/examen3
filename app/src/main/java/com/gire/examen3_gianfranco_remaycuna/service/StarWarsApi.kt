package com.gire.examen3_gianfranco_remaycuna.service

import com.gire.examen3_gianfranco_remaycuna.model.PeopleResponse
import retrofit2.Response
import retrofit2.http.GET

interface StarWarsApi {
    @GET("people/")
    suspend fun getPeople(): Response<PeopleResponse>

}