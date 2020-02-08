package com.jrkk61.nytimesapi.network

import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface NYTService {
    @GET( "/topstories/v2/{section}.json")
    fun getTopStories(
        @Path("section") section: String,
        @Query("api_key") api_key:String
    )

}
