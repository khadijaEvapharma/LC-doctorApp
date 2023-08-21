package com.limitlesscare.doctor.app_versions.domain.usecases

import com.limitlesscare.core.domain.DataState
import com.limitlesscare.core.domain.ISuspendableUseCase
import com.limitlesscare.doctor.app_versions.domain.model.AppVersionsResponse
import com.limitlesscare.doctor.app_versions.domain.repository.AppVersionsRepo
import javax.inject.Inject

class GetAllAppVersionsUseCase @Inject constructor(
    private val repo: AppVersionsRepo,
) : ISuspendableUseCase.WithoutParams<DataState<AppVersionsResponse>> {
    override suspend fun invoke() = repo.getAppVersions()
}