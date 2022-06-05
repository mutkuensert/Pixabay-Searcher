package com.mutkuensert.pixabaysearcher.module

import com.mutkuensert.pixabaysearcher.service.PixabayService
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object PixabaySearcherModule {

    @Singleton
    @Provides
    fun providePixabayService(): PixabayService {
        val moshi = Moshi.Builder().add(KotlinJsonAdapterFactory()).build()

        return Retrofit.Builder().baseUrl("https://pixabay.com/")
            .addConverterFactory(MoshiConverterFactory.create(moshi))
            .build().create(PixabayService::class.java)
    }
}