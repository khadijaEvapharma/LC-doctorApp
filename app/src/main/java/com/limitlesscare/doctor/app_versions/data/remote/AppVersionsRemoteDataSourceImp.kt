package com.limitlesscare.doctor.app_versions.data.remote

import com.limitlesscare.core.domain.DataState
import com.limitlesscare.doctor.app_core.data.remote.model.getDataState
import com.limitlesscare.doctor.app_versions.domain.model.AppVersionsResponse
import javax.inject.Inject

class AppVersionsRemoteDataSourceImp @Inject constructor(
    private val appVersionsApiService: AppVersionsApiService
) : AppVersionsRemoteDataSource {
    override suspend fun getAppVersions(): DataState<AppVersionsResponse> {
                return try {
                    appVersionsApiService.getAppVersions().getDataState()
        } catch (e: Throwable) {
            DataState.Error(e)
        }
    }

}