package com.example.data.remote.pojos

import com.example.domain.model.AuthorUserStatus

data class Author(
    val contestId: Int,
    val ghost: Boolean,
    val members: List<Member>,
    val participantType: String,
    val startTimeSeconds: Int
)

fun Author.toAuthorUserStatus() : AuthorUserStatus = AuthorUserStatus(
    contestId = contestId,
    ghost = ghost,
    members = members.map { it.toMemberUserStatus() },
    participantType = participantType
)