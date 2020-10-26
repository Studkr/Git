package com.gitrepository.screen.home.item

import androidx.lifecycle.ViewModel
import com.gitrepository.di.factory.ViewModelKey
import dagger.Binds
import dagger.Module
import dagger.android.ContributesAndroidInjector
import dagger.multibindings.IntoMap


@Module
interface ItemHomeModule{
    @ContributesAndroidInjector(modules = [
        ItemHomeViewModelModule::class
    ])
    fun inject(): HomeItemFragment
}

@Module
interface ItemHomeViewModelModule{
    @Binds
    @IntoMap
    @ViewModelKey(HomeItemViewModel::class)
    fun viewModel(viewModel: HomeItemViewModel):ViewModel
}