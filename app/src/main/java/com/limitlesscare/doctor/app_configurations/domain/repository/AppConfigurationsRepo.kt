package com.limitlesscare.doctor.app_configurations.domain.repository

interface AppConfigurationsRepo {
    suspend fun updateConfiguration()
    suspend fun getConfiguration()
}