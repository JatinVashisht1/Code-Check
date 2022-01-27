package com.example.di

import com.example.core.Constants
import com.example.data.remote.repository.CFRepoImpl
import com.example.data.remote.repository.CodeforcesApi
import com.example.domain.CFRepo
//import com.example.domain.CFRepo
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {
    @Provides
    @Singleton
    fun provideApi(): CodeforcesApi = Retrofit.Builder()
        .addConverterFactory(GsonConverterFactory.create())
        .baseUrl(Constants.BASE_URL)
        .build()
        .create(CodeforcesApi::class.java)

    @Provides
    @Singleton
    fun providesRepository(api: CodeforcesApi): CFRepo = CFRepoImpl(api = api)
}