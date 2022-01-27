package com.example.data.remote.pojos

import com.example.domain.model.AuthorContestStatus

data class AuthorX(
    val contestId: Int,
    val ghost: Boolean,
    val members: List<MemberX>,
    val participantType: String,
    val startTimeSeconds: Int
)

fun AuthorX.toAuthorContestStatus() = AuthorContestStatus(
    contestId = contestId,
    ghost = ghost,
    members = members.map{it.toMemberContestStatus()},
    participantType = participantType,
    startTimeSeconds = startTimeSeconds
)