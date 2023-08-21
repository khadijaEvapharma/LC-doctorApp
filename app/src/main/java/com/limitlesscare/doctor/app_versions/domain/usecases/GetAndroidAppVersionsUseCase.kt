package com.limitlesscare.doctor.app_versions.domain.usecases

import com.limitlesscare.core.domain.DataState
import com.limitlesscare.core.domain.ISuspendableUseCase
import com.limitlesscare.doctor.app_versions.domain.model.AppVersions
import com.limitlesscare.doctor.app_versions.domain.model.AppVersionsResponse
import com.limitlesscare.doctor.app_versions.domain.repository.AppVersionsRepo
import javax.inject.Inject

class GetAndroidAppVersionsUseCase @Inject constructor(
    private val repo: AppVersionsRepo,
) : ISuspendableUseCase.WithoutParams<DataState<AppVersions>> {
    override suspend fun invoke(): DataState<AppVersions> {
        val dataState = repo.getAppVersions()
        return if (dataState is DataState.Success && dataState.data.android !=null){
            dataState.data.android?.let {
                return  DataState.Success(it)
            }
            return DataState.Error(RuntimeException(""))
        } else {
            DataState.Error(RuntimeException(""))
        }
    }

}