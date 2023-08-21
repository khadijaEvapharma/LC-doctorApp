package com.limitlesscare.doctor.splash_flow.di

import android.content.Context
import com.limitlesscare.doctor.dataStore
import com.limitlesscare.doctor.splash_flow.data.datastore.SplashLocalDataSource
import com.limitlesscare.doctor.splash_flow.data.datastore.SplashLocalDataSourceImp
import com.limitlesscare.doctor.splash_flow.data.remote.SplashRemoteDataSource
import com.limitlesscare.doctor.splash_flow.data.remote.SplashRemoteDataSourceImp
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
abstract class DataSourceModule {

    @Singleton
    @Binds
    abstract fun bindNetworkDataSource(dataSource: SplashRemoteDataSourceImp): SplashRemoteDataSource
}

@Module
@InstallIn(SingletonComponent::class)
object DataStoreModule {

    @Provides
    @Singleton
     fun provideDataStore(@ApplicationContext context: Context): SplashLocalDataSource{
         return SplashLocalDataSourceImp(context.dataStore)

     }

}