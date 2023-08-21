package com.limitlesscare.doctor.auth_flow.data.repository

import com.limitlesscare.core.domain.DataState
import com.limitlesscare.doctor.auth_flow.data.local.AuthLocalDataSource
import com.limitlesscare.doctor.auth_flow.data.remote.AuthRemoteDataSource
import com.limitlesscare.doctor.auth_flow.domain.model.LoginData
import com.limitlesscare.doctor.auth_flow.domain.model.LoginResponse
import com.limitlesscare.doctor.auth_flow.domain.repo.AuthRepo
import javax.inject.Inject

class AuthRepoImpl @Inject constructor(
    private val remoteDataSource: AuthRemoteDataSource,
    private val localDataSource: AuthLocalDataSource
) : AuthRepo {
    override suspend fun login(data: LoginData): DataState<LoginResponse> {
        val responseDataState: DataState<LoginResponse> = remoteDataSource.login(data)
        if (responseDataState is DataState.Success) {
            localDataSource.updateDoctorData(responseDataState.data)
        }
        return responseDataState

    }
}