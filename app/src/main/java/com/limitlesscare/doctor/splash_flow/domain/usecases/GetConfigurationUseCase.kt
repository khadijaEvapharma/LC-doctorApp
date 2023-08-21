package com.limitlesscare.doctor.splash_flow.domain.usecases

import com.limitlesscare.core.domain.ISuspendableUseCase
import com.limitlesscare.doctor.app_versions.domain.repository.AppVersionsRepo
import javax.inject.Inject

class GetConfigurationUseCase @Inject constructor(
    private val appVersionsRepo: AppVersionsRepo,
): ISuspendableUseCase.WithoutParams<Unit> {

    override suspend fun invoke() {

    }
}