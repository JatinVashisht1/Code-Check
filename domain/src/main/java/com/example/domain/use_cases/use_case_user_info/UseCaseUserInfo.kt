package com.example.domain.use_cases.use_case_user_info

import android.util.Log
import com.example.core.Constants
import com.example.core.Resource
import com.example.domain.CFRepo
import com.example.domain.model.ModelContestStatus
import com.example.domain.model.ModelUserInfo
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import java.io.IOException
import java.lang.Exception
import java.net.HttpRetryException
import javax.inject.Inject

class UseCaseUserInfo @Inject constructor(private val repo: CFRepo) {
    suspend operator  fun invoke(handles: String): Flow<Resource<ModelUserInfo>> = flow {
        try {
            emit(Resource.Loading<ModelUserInfo>())
            val data = repo.getUserInfo(handles = handles)
            emit(Resource.Success<ModelUserInfo>(data = data))
        }catch (e: HttpRetryException){
            Log.d(Constants.EXCEPTION_TAG,"Error in UseCaseUserInfo (HttpRetryExcept.): ${e.toString()}")
            emit(Resource.Error<ModelUserInfo>(e.localizedMessage ?: "Unable to reach server, check internet connection or try again"))
        }
        catch(e: IOException){
            Log.d(Constants.EXCEPTION_TAG,"Error in UseCaseUserInfo (IOExcept.): ${e.toString()}")
            emit(Resource.Error<ModelUserInfo>(e.localizedMessage ?: "Unable to reach server, check internet connection or try again"))
        }
        catch (e: Exception){
            Log.d(Constants.EXCEPTION_TAG,"Error in UseCaseUserInfo (Except.): ${e.toString()}")
            emit(Resource.Error<ModelUserInfo>(e.localizedMessage ?: "Unable to reach server, check internet connection or try again"))
        }
    }
}