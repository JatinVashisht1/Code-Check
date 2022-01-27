package com.example.data.remote.pojos

import com.example.domain.model.ModelContestList

data class ContestList(
    val result: List<ResultXXX>,
    val status: String
)

fun ContestList.toModelContestList() : ModelContestList = ModelContestList(result.map{it.toModelContestList()})