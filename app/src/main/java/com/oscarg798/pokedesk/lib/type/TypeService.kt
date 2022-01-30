package com.oscarg798.pokedesk.lib.type

import com.oscarg798.pokedesk.lib.pokemon.model.ApiType
import retrofit2.http.GET
import retrofit2.http.Path

interface TypeService {

    @GET("type/{id}")
    suspend fun getTypeById(@Path("id") id: Int): ApiType
}
