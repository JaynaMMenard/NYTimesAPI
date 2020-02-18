package com.jrkk61.nytimesapi.model


data class Result(
    val title: String,
    val abstract: String,
    val multimedia: List<Multimedia>

)


