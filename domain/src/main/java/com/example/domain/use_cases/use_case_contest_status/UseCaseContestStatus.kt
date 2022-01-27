package com.example.domain.use_cases.use_case_contest_status

import android.util.Log
import com.example.core.Constants
import com.example.core.Resource
import com.example.domain.CFRepo
import com.example.domain.model.ModelContestStatus
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import java.io.IOException
import java.lang.Exception
import java.net.HttpRetryException
import javax.inject.Inject

class UseCaseContestStatus @Inject constructor(private val repo: CFRepo) {
    suspend operator  fun invoke(contestId: Int, from: Int, count: Int): Flow<Resource<ModelContestStatus>> = flow {
        try {
            emit(Resource.Loading<ModelContestStatus>())
            val data = repo.getContestStatus(contestId = contestId, from = from, count = count)
            emit(Resource.Success<ModelContestStatus>(data = data))
        }catch (e: HttpRetryException){
            Log.d(Constants.EXCEPTION_TAG,"Error in UseCaseContentStatus (HttpRetryExcept.): ${e.toString()}")
            emit(Resource.Error<ModelContestStatus>(e.localizedMessage ?: "Unable to reach server, check internet connection or try again"))
        }
        catch(e: IOException){
            Log.d(Constants.EXCEPTION_TAG,"Error in UseCaseContentStatus (IOExcept.): ${e.toString()}")
            emit(Resource.Error<ModelContestStatus>(e.localizedMessage ?: "Unable to reach server, check internet connection or try again"))
        }
        catch (e: Exception){
            Log.d(Constants.EXCEPTION_TAG,"Error in UseCaseContentStatus (Except.): ${e.toString()}")
            emit(Resource.Error<ModelContestStatus>(e.localizedMessage ?: "Unable to reach server, check internet connection or try again"))
        }
    }
}