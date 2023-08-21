package com.limitlesscare.doctor.auth_flow.data.remote

import com.limitlesscare.doctor.app_core.data.remote.model.BaseResponse
import com.limitlesscare.doctor.app_core.data.remote.utils.EndPoints
import com.limitlesscare.doctor.auth_flow.domain.model.LoginData
import com.limitlesscare.doctor.auth_flow.domain.model.LoginResponse
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.PUT

interface AuthAPI {

    @PUT(EndPoints.LOGIN)
    suspend fun login(@Body loginData: LoginData): Response<BaseResponse<LoginResponse>>
}