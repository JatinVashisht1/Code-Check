package com.example.domain.use_cases.use_case_user_rating

import android.util.Log
import com.example.core.Constants
import com.example.core.Resource
//import com.example.data.remote.pojos.Result
import com.example.domain.CFRepo
import com.example.domain.model.ModelUserRating
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import java.io.IOException
import javax.inject.Inject


class UseCaseUserRating @Inject constructor(private val repo: CFRepo) {
    suspend operator fun invoke(handle: String): Flow<Resource<List<ModelUserRating>>> = flow {
        try {
            emit(Resource.Loading())
            val data = repo.getUserRating(userHandle = "Fefer_Ivan")
            Log.d(Constants.EXCEPTION_TAG, "data in use case is: ${data.toString()}")
            emit(Resource.Success(data))
        }
        catch (e: IOException){
            emit(Resource.Error(message = e.localizedMessage ?: "unable to reach server"))
        }
        catch (e: Exception){
            Log.d(Constants.EXCEPTION_TAG, "Exception occurred in Rating use case: $e")
            emit(Resource.Error("An error occurred, try again"))
        }
    }
}