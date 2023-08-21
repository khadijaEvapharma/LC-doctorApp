package com.limitlesscare.doctor.auth_flow.di

import android.content.Context
import androidx.datastore.core.DataStore
import com.limitlesscare.doctor.DoctorData
import com.limitlesscare.doctor.auth_flow.data.local.AuthLocalDataSource
import com.limitlesscare.doctor.auth_flow.data.local.AuthLocalDataSourceImp
import com.limitlesscare.doctor.auth_flow.data.local.userPreferencesStore
import com.limitlesscare.doctor.auth_flow.data.remote.AuthAPI
import com.limitlesscare.doctor.auth_flow.data.remote.AuthRemoteDataSource
import com.limitlesscare.doctor.auth_flow.data.remote.AuthRemoteDataSourceImp
import com.limitlesscare.doctor.auth_flow.data.repository.AuthRepoImpl
import com.limitlesscare.doctor.auth_flow.domain.repo.AuthRepo
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class AuthModule {

    @Binds
    abstract fun bindRepository(repository: AuthRepoImpl): AuthRepo

    @Binds
    abstract fun bindRemoteDataSource(remoteDataSourceImp: AuthRemoteDataSourceImp): AuthRemoteDataSource

    @Binds
    abstract fun bindLocalDataSource(localDataSourceImp: AuthLocalDataSourceImp): AuthLocalDataSource
}

@Module
@InstallIn(SingletonComponent::class)
class ApiServicesModule {
    @Provides
    @Singleton
    fun provideAuthApiService(retrofit: Retrofit): AuthAPI {
        return retrofit.create(AuthAPI::class.java)
    }
}

@InstallIn(SingletonComponent::class)
@Module
object DataStoreModule {

    @Singleton
    @Provides
    fun providePreferencesDataStore(@ApplicationContext appContext: Context): DataStore<DoctorData> {
        return appContext.userPreferencesStore
    }
}
