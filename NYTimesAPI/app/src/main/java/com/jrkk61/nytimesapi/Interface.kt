package com.jrkk61.nytimesapi
import com.jrkk61.nytimesapi.Section
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

internal interface Interface {
    @GET("/svc/topstories/v2/{section}")
    fun getSection(
            @Path("section") section: String?,
            @Query("api-key") key: String?): Call<Section?>?
}