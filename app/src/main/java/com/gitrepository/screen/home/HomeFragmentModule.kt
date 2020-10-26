package com.gitrepository.screen.home

import androidx.lifecycle.ViewModel
import com.gitrepository.di.factory.ViewModelKey
import com.gitrepository.screen.home.item.ItemHomeModule
import dagger.Binds
import dagger.Module
import dagger.android.ContributesAndroidInjector
import dagger.multibindings.IntoMap

@Module
interface HomeFragmentModule {
    @ContributesAndroidInjector(
        modules = [
            HomeFragmentViewModelModule::class,
            ItemHomeModule::class
        ]
    )
    fun inject(): HomeFragment
}

@Module
interface HomeFragmentViewModelModule {
    @Binds
    @IntoMap
    @ViewModelKey(HomeViewModel::class)
    fun viewModel(viewModel: HomeViewModel): ViewModel
}