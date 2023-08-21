package com.limitlesscare.doctor.auth_flow.data.local

import com.limitlesscare.doctor.auth_flow.domain.model.LoginResponse

interface AuthLocalDataSource {
    suspend fun updateDoctorData(loginResponse: LoginResponse)
    suspend fun getToken(): String
    suspend fun getDoctorData(): LoginResponse
}