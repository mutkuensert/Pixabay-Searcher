package com.mutkuensert.pixabaysearcher.service

import com.mutkuensert.pixabaysearcher.model.MainModel
import com.mutkuensert.pixabaysearcher.util.API_KEY
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface PixabayService {
    @GET("api")
    suspend fun searchPictures(
        @Query("key") key: String = API_KEY,
        @Query("q") searchText: String,
    ): Response<MainModel>
}