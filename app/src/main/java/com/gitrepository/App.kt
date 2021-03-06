package com.gitrepository

import com.airbnb.epoxy.EpoxyAsyncUtil
import com.airbnb.epoxy.EpoxyController
import com.github.ajalt.timberkt.BuildConfig
import com.github.ajalt.timberkt.Timber
import com.gitrepository.db.DataBaseModule
import com.gitrepository.di.AppModule
import com.gitrepository.di.DaggerAppComponent
import dagger.android.AndroidInjector
import dagger.android.DaggerApplication

open class App : DaggerApplication() {

    open val component: AndroidInjector<DaggerApplication> by lazy {
        DaggerAppComponent.builder()
            .application(this)
            .dataBase(DataBaseModule(this))
            .appModule(AppModule(this))
            .build()
    }

    override fun applicationInjector(): AndroidInjector<out DaggerApplication> = component

    override fun onCreate() {
        super.onCreate()
        if (BuildConfig.DEBUG) {
            Timber.plant(Timber.DebugTree())
        }

        val handler = EpoxyAsyncUtil.getAsyncBackgroundHandler()
        EpoxyController.defaultDiffingHandler = handler
        EpoxyController.defaultModelBuildingHandler = handler

    }

}