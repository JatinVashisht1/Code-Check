package com.example.codecheck

import com.example.domain.CFRepo
import com.example.domain.use_cases.use_case_user_rating.UseCaseUserRating
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {
//    @Provides
//    @Singleton
//    fun provideUseCase(repo: CFRepo): UseCaseUserRating {
//        return UseCaseUserRating(repo)
//    }
}