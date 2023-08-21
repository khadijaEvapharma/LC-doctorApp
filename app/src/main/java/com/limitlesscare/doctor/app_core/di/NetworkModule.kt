package com.limitlesscare.doctor.app_core.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
class NetworkModule {

    @Provides
    @Singleton
    fun providesRetrofit(okHttpClient: OkHttpClient):Retrofit{
        return Retrofit.Builder()
            .client(okHttpClient)
            .baseUrl(com.limitlesscare.doctor.BuildConfig.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

    }

    @Provides
    fun createOkHttpClient():OkHttpClient{
       val httpLoggingInterceptor=HttpLoggingInterceptor()
        httpLoggingInterceptor.level=HttpLoggingInterceptor.Level.BODY
        return OkHttpClient().newBuilder()
            .connectTimeout(60L, TimeUnit.SECONDS)
            .readTimeout(60L,TimeUnit.SECONDS)
            .callTimeout(60L,TimeUnit.SECONDS)
            .writeTimeout(60L,TimeUnit.SECONDS)
            .addInterceptor(httpLoggingInterceptor).build()
    }

}