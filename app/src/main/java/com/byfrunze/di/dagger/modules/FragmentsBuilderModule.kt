package com.byfrunze.di.dagger.modules

import com.byfrunze.di.ui.main.MainFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class FragmentsBuilderModule {

    @ContributesAndroidInjector
    abstract fun mainFragment(): MainFragment
}