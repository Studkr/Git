package com.gitrepository.screen

import androidx.appcompat.app.AppCompatActivity
import com.gitrepository.di.ActivityScope
import com.gitrepository.screen.home.HomeFragmentModule
import dagger.Module
import dagger.Provides
import dagger.android.ContributesAndroidInjector

@Module
interface MainActivityModule {
    @ContributesAndroidInjector(modules = [
        HomeFragmentModule::class
    ])
    @ActivityScope
    fun activity(): MainActivity
}

@Module
class MainActivityActivityModule {

    @Provides
    @ActivityScope
    fun activity(a: MainActivity): AppCompatActivity = a

}