package com.limitlesscare.doctor.splash_flow.data.datastore

interface SplashLocalDataSource {
   suspend fun getConfigurationVersion(): String?
   suspend fun setConfigurationVersion(version: String)
}