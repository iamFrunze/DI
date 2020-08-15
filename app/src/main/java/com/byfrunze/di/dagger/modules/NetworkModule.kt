package com.byfrunze.di.dagger.modules

import com.byfrunze.di.utils.MovieDBApi
import com.byfrunze.di.utils.URL
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
class NetworkModule {

    @Singleton
    @Provides
    fun provideRetrofit(): Retrofit =
        Retrofit.Builder()
            .baseUrl(URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

    @Singleton
    @Provides
    fun provideApiService(retrofit: Retrofit): MovieDBApi =
        retrofit.create(MovieDBApi::class.java)
}