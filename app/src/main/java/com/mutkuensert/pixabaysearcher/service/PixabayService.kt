package com.mutkuensert.pixabaysearcher.service

import com.mutkuensert.pixabaysearcher.model.MainModel
import com.mutkuensert.pixabaysearcher.util.ApiKey
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface PixabayService {
    @GET("api")
    suspend fun searchPictures(
        @Query("key") key: String = ApiKey.apiKey,
        @Query("q") searchText: String,
    ): Response<MainModel>
}