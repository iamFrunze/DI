package com.byfrunze.di.dagger.components

import android.content.Context
import com.byfrunze.di.MovieApplication
import com.byfrunze.di.dagger.modules.*
import dagger.BindsInstance
import dagger.Component
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        AndroidSupportInjectionModule::class,
        ViewModelModule::class,
        AppModule::class,
        FragmentsBuilderModule::class,
        NetworkModule::class
    ]
)
interface AppComponent {
    @Component.Builder
    interface Builder {
        @BindsInstance
        fun application(app: MovieApplication): Builder
        fun build(): AppComponent
    }

    fun inject(app: MovieApplication)
}