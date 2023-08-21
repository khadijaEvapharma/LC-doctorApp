package com.limitlesscare.doctor.app_configurations.data.repository

import com.limitlesscare.doctor.app_configurations.domain.repository.AppConfigurationsRepo
import javax.inject.Inject

class AppConfigurationsRepoImp @Inject constructor(

):AppConfigurationsRepo{
    override suspend fun updateConfiguration() {
        TODO("Not yet implemented")
    }

    override suspend fun getConfiguration() {
        TODO("Not yet implemented")
    }
}