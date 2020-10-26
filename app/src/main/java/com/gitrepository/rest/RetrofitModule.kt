package com.flipsidegroup.nmt.rest

import com.gitrepository.rest.JsonModule
import com.gitrepository.rest.createOkHttpClient
import com.gitrepository.rest.createRetrofit
import com.gitrepository.rest.getLoggingInterceptor
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Converter
import javax.inject.Named
import javax.inject.Singleton

const val BASE_URL = "https://api.github.com"

@Module(includes = [JsonModule::class])
class RetrofitModule {

    @Provides
    @Singleton
    fun retrofit(
        @Named(BASE_URL) baseUrl: String,
        okHttpClient: OkHttpClient,
        converterFactory: Converter.Factory
    ) = createRetrofit(
        baseUrl = baseUrl,
        okHttpClient = okHttpClient,
        converterFactory = converterFactory
    )

    @Provides
    @Singleton
    @Named(BASE_URL)
    fun baseUrl() = BASE_URL


    @Provides
    @Singleton
    fun okHttpClient(
        loggingInterceptor: HttpLoggingInterceptor
    ) = createOkHttpClient(loggingInterceptor)

    @Provides
    @Singleton
    fun loggingInterceptor() = getLoggingInterceptor()

}