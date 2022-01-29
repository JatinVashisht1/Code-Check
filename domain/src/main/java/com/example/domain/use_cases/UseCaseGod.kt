package com.example.domain.use_cases

import com.example.domain.use_cases.use_case_contest_list.UseCaseContestList
import com.example.domain.use_cases.use_case_contest_status.UseCaseContestStatus
import com.example.domain.use_cases.use_case_user_info.UseCaseUserInfo
import com.example.domain.use_cases.use_case_user_rating.UseCaseUserRating
import com.example.domain.use_cases.use_case_user_status.UseCaseUserStatus

// I have not implemented UseCaseContentList because it provides a large amount of data
data class UseCaseGod(
    val useCaseUserStatus: UseCaseUserStatus,
    val useCaseUserRating: UseCaseUserRating,
    val useCaseContestStatus: UseCaseContestStatus,
    val useCaseUserInfo: UseCaseUserInfo
)
