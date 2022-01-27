package com.example.data.remote.pojos

import com.example.domain.model.MemberContestStatus

data class MemberX(
    val handle: String
)

fun MemberX.toMemberContestStatus() : MemberContestStatus = MemberContestStatus(handle = handle)