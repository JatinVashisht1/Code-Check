package com.example.domain.di

import com.example.domain.CFRepo
import com.example.domain.use_cases.UseCaseGod
import com.example.domain.use_cases.use_case_contest_status.UseCaseContestStatus
import com.example.domain.use_cases.use_case_user_rating.UseCaseUserRating
import com.example.domain.use_cases.use_case_user_status.UseCaseUserStatus
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
    fun provideGodUseCase(repo: CFRepo) : UseCaseGod = UseCaseGod(
        useCaseContestStatus = UseCaseContestStatus(repo = repo),
        useCaseUserRating = UseCaseUserRating(repo = repo),
        useCaseUserStatus = UseCaseUserStatus(repo = repo)
    )
}