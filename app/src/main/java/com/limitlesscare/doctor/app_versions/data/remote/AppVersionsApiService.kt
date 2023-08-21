package com.limitlesscare.doctor.app_versions.data.remote

import com.limitlesscare.doctor.app_core.data.remote.model.BaseResponse
import com.limitlesscare.doctor.app_core.data.remote.utils.EndPoints
import com.limitlesscare.doctor.app_versions.domain.model.AppVersionsResponse
import retrofit2.Response
import retrofit2.http.GET

interface AppVersionsApiService {

    @GET(EndPoints.APP_VERSION)
    suspend fun getAppVersions():Response<BaseResponse<AppVersionsResponse>>
}