package com.limitlesscare.doctor.splash_flow.data.datastore

import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import javax.inject.Inject

class SplashLocalDataSourceImp @Inject constructor(
    private val dataStore: DataStore<Preferences>
) : SplashLocalDataSource {

    override suspend fun getConfigurationVersion(): String? {
        TODO("Not yet implemented")
    }

    override suspend fun setConfigurationVersion(version: String) {
        TODO("Not yet implemented")
    }




    }

