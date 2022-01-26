package com.example.domain.use_cases.use_case_user_rating

import android.util.Log
import com.example.core.Constants
import com.example.core.Resource
import com.example.data.remote.pojos.Result
import com.example.data.remote.repository.CFRepo
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import java.io.IOException
import javax.inject.Inject


class UseCaseUserRating @Inject constructor(private val repository: CFRepo) {
    suspend operator fun invoke(handle: String): Flow<Resource<List<Result>>> = flow {
        try {
            emit(Resource.Loading())
            val data = repository.getUserRating(userHandle = handle)
            val result = data.map {
                Result(
                    contestId = it.contestId,
                    contestName = it.contestName,
                    handle = it.handle,
                    newRating = it.newRating,
                    oldRating = it.oldRating,
                    rank = it.rank,
                    ratingUpdateTimeSeconds = it.ratingUpdateTimeSeconds
                )
            }
            emit(Resource.Success(result))
        }
        catch (e: IOException){
            emit(Resource.Error(message = e.localizedMessage ?: "unable to reach server"))
        }
        catch (e: Exception){
            emit(Resource.Error("An error occurred, try again"))
            Log.d(Constants.EXCEPTION_TAG, "Exception occurred in Rating use case: $e")
        }
    }
}