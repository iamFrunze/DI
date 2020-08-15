package com.byfrunze.di.utils

import com.byfrunze.di.data.MovieDB
import retrofit2.http.GET
import retrofit2.http.Query

interface MovieDBApi {

    @GET("movie/popular")
    suspend fun getMovie(
        @Query("api_key") apiKey: String,
        @Query("language") lang: String,
        @Query("page") page: Int
    ): MovieDB

}