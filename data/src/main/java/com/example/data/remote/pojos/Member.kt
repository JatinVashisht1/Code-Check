package com.example.data.remote.pojos

import com.example.domain.model.MemberUserStatus

data class Member(
    val handle: String
)

fun Member.toMemberUserStatus() : MemberUserStatus = MemberUserStatus(
    handle = handle
)