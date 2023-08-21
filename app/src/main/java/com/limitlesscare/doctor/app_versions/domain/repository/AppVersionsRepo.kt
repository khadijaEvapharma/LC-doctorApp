package com.limitlesscare.doctor.app_versions.domain.repository

import com.limitlesscare.core.domain.DataState
import com.limitlesscare.doctor.app_versions.domain.model.AppVersionsResponse

interface AppVersionsRepo {
    suspend fun getAppVersions(): DataState<AppVersionsResponse>
}
