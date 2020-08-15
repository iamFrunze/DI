package com.byfrunze.di.dagger.modules

import android.content.Context
import com.byfrunze.di.MovieApplication
import dagger.Module
import dagger.Provides

@Module
class AppModule {

    @Provides
    fun provideContext(app: MovieApplication): Context {
        return app.applicationContext
    }
}