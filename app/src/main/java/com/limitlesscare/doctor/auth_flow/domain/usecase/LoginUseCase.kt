package com.limitlesscare.doctor.auth_flow.domain.usecase

import com.limitlesscare.core.domain.DataState
import com.limitlesscare.core.domain.ISuspendableUseCase
import com.limitlesscare.doctor.auth_flow.domain.model.LoginData
import com.limitlesscare.doctor.auth_flow.domain.model.LoginResponse
import com.limitlesscare.doctor.auth_flow.domain.repo.AuthRepo
import javax.inject.Inject

class LoginUseCase @Inject constructor(
    private val repo: AuthRepo,
) : ISuspendableUseCase.WithParams<LoginData, DataState<LoginResponse>> {
    override suspend fun invoke(input: LoginData): DataState<LoginResponse> {
        return repo.login(input)
    }
}