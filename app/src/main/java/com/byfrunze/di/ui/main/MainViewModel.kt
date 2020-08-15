package com.byfrunze.di.ui.main

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.byfrunze.di.utils.MovieDBApi
import com.byfrunze.di.utils.api_key
import com.byfrunze.di.utils.lang
import kotlinx.coroutines.launch
import javax.inject.Inject

class MainViewModel @Inject constructor(var movieApi: MovieDBApi) : ViewModel() {

    init {
        loadMovies()
    }

    private fun loadMovies() {
        viewModelScope.launch {
           val res =  movieApi.getMovie(
                apiKey = api_key,
                lang = lang,
                page = 1
            )

            Log.i("DAGGER", res.toString())
        }
    }

}

