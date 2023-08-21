package com.limitlesscare.doctor.auth_flow.data.remote

import com.limitlesscare.core.domain.DataState
import com.limitlesscare.doctor.auth_flow.domain.model.LoginData
import com.limitlesscare.doctor.auth_flow.domain.model.LoginResponse

interface AuthRemoteDataSource {
    suspend fun login(loginData: LoginData): DataState<LoginResponse>
}