package com.example.domain.di

import com.example.data.remote.repository.CFRepo
import com.example.data.remote.repository.CFRepoImpl
import com.example.data.remote.repository.CodeforcesApi
import com.example.domain.use_cases.use_case_user_rating.UseCaseUserRating
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {
    @Provides
    @Singleton
    fun providesRepository(api: CodeforcesApi): CFRepo = CFRepoImpl(api = api)

    fun providesUseCaseRating(repository: CFRepoImpl) : UseCaseUserRating = UseCaseUserRating(repository = repository)
}