package com.example.codecheck.presentation

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.core.Constants
import com.example.domain.use_cases.UseCaseGod
import com.example.domain.use_cases.use_case_contest_status.UseCaseContestStatus
import com.example.domain.use_cases.use_case_user_rating.UseCaseUserRating
import com.example.domain.use_cases.use_case_user_status.UseCaseUserStatus
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val useCaseUserRating: UseCaseUserRating,
    private val useCaseUserStatus: UseCaseUserStatus,
    private  val useCaseContestStatus: UseCaseContestStatus,
    private val god: UseCaseGod
) :
    ViewModel() {
    init {
        viewModelScope.launch(IO) {
            getData()
        }
    }
    suspend fun getData(){
        val data = useCaseUserRating("Fefer_Ivan").onEach {
            Log.d(Constants.VIEWMODEL_TAG, "Data in viewModel, ${it.data.toString()}")
        }.launchIn(viewModelScope)

        val userStatus = useCaseUserStatus("Fefer_Ivan", 1, 10).onEach {
            Log.d(Constants.VIEWMODEL_TAG, "Data in viewModel (user status) ${it.data?.resultUserStatus.toString()}")
        }.launchIn(viewModelScope)

        val contentStatus = useCaseContestStatus(contestId = 566, from = 1, count = 10).onEach {
            Log.d(Constants.VIEWMODEL_TAG, "Data in viewModel (contest status) ${it.data?.resultContestStatuses.toString()}")
        }.launchIn(viewModelScope)

        val god = god.useCaseContestStatus(contestId = 566, from = 1, count = 10).onEach {
            Log.d(Constants.VIEWMODEL_TAG, "Data in viewModel (god use case) ${it.data?.resultContestStatuses.toString()}")
        }.launchIn(viewModelScope)
    }
}