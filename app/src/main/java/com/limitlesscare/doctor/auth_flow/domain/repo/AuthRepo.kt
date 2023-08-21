package com.limitlesscare.doctor.auth_flow.domain.repo

import com.limitlesscare.core.domain.DataState
import com.limitlesscare.doctor.auth_flow.domain.model.LoginData
import com.limitlesscare.doctor.auth_flow.domain.model.LoginResponse

interface AuthRepo {
    suspend fun login(data: LoginData): DataState<LoginResponse>
}