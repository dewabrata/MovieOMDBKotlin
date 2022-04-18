package com.adl.movieomdb.service

import com.adl.movieomdb.model.OMDBResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface OMDBApiInterface {
        @GET("?apikey=80641bfb")

        fun getMovie( @Query("s") query: String): Call<OMDBResponse>
}
