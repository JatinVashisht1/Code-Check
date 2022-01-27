package com.example.domain.use_cases.use_case_user_status

import android.util.Log
import com.example.core.Constants
import com.example.core.Resource
import com.example.domain.CFRepo
import com.example.domain.model.ModelUserStatus
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import java.io.IOException
import java.lang.Exception
import java.net.HttpRetryException
import javax.inject.Inject

class UseCaseUserStatus @Inject constructor(private val repo: CFRepo) {
    suspend operator fun invoke(userHandle: String, fromIndex: Int, count: Int) : Flow<Resource<ModelUserStatus>> = flow{
        try{
            emit(Resource.Loading<ModelUserStatus>())
            val data = repo.getUserStatus(userHandle = userHandle, fromIndex = fromIndex, count = count)
            emit(Resource.Success<ModelUserStatus>(data = data))
        }catch (e: HttpRetryException){
            Log.d(Constants.EXCEPTION_TAG,"Error in UseCaseUserStatus (HttpRetryExcept.): ${e.toString()}")
            emit(Resource.Error<ModelUserStatus>(e.localizedMessage ?: "Unable to reach server, check internet connection or try again"))
        }
        catch(e: IOException){
            Log.d(Constants.EXCEPTION_TAG,"Error in UseCaseUserStatus (IOExcept.): ${e.toString()}")
            emit(Resource.Error<ModelUserStatus>(e.localizedMessage ?: "Unable to reach server, check internet connection or try again"))
        }
        catch (e: Exception){
            Log.d(Constants.EXCEPTION_TAG,"Error in UseCaseUserStatus (Except.): ${e.toString()}")
            emit(Resource.Error<ModelUserStatus>(e.localizedMessage ?: "Unable to reach server, check internet connection or try again"))
        }
    }
}