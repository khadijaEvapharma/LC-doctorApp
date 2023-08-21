package com.limitlesscare.doctor.app_versions.di

import android.content.Context
import com.limitlesscare.doctor.app_versions.data.remote.AppVersionsApiService
import com.limitlesscare.doctor.app_versions.data.remote.AppVersionsRemoteDataSource
import com.limitlesscare.doctor.app_versions.data.remote.AppVersionsRemoteDataSourceImp
import com.limitlesscare.doctor.app_versions.data.repository.AppVersionsRepoImp
import com.limitlesscare.doctor.app_versions.domain.repository.AppVersionsRepo
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {

    @Singleton
    @Binds
    abstract fun bindRepository(repository: AppVersionsRepoImp): AppVersionsRepo
}

@Module
@InstallIn(SingletonComponent::class)
abstract class DataSourceModule {

    @Singleton
    @Binds
    abstract fun bindNetworkDataSource(dataSource: AppVersionsRemoteDataSourceImp): AppVersionsRemoteDataSource
}

@Module
@InstallIn(SingletonComponent::class)
class ApiServicesModule{
    @Provides
    @Singleton
    fun provideAppVersionsApiService(retrofit: Retrofit):AppVersionsApiService{
        return retrofit.create(AppVersionsApiService::class.java)
    }
}
