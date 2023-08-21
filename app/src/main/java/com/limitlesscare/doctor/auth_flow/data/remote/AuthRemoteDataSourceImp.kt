package com.limitlesscare.doctor.auth_flow.data.remote

import com.limitlesscare.core.domain.DataState
import com.limitlesscare.doctor.app_core.data.remote.model.getDataState
import com.limitlesscare.doctor.auth_flow.domain.model.LoginData
import com.limitlesscare.doctor.auth_flow.domain.model.LoginResponse
import javax.inject.Inject

class AuthRemoteDataSourceImp @Inject constructor(
    private val authAPI: AuthAPI
) : AuthRemoteDataSource {
    override suspend fun login(loginData: LoginData): DataState<LoginResponse> {
        return try {
            authAPI.login(loginData).getDataState()
        } catch (e: Throwable) {
            DataState.Error(e)
        }
    }

}