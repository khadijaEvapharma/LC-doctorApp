package com.limitlesscare.doctor.splash_flow.data.remote

interface SplashRemoteDataSource {

    suspend fun getConfiguration()
}