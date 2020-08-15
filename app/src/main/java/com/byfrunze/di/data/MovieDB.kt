package com.byfrunze.di.data

data class MovieDB(
    val page: Int,
    val results: List<MovieDBList>
)

data class MovieDBList(
    val poster_path: String,
    val title: String
)

