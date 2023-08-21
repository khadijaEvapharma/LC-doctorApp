package com.limitlesscare.doctor.app_versions.data.remote

import com.limitlesscare.core.domain.DataState
import com.limitlesscare.doctor.app_versions.domain.model.AppVersionsResponse

interface AppVersionsRemoteDataSource {
    suspend fun getAppVersions(): DataState<AppVersionsResponse>
}


