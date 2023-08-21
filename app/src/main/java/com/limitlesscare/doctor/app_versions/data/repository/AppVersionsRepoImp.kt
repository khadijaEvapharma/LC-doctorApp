package com.limitlesscare.doctor.app_versions.data.repository

import com.limitlesscare.core.domain.DataState
import com.limitlesscare.doctor.app_versions.data.remote.AppVersionsRemoteDataSource
import com.limitlesscare.doctor.app_versions.domain.repository.AppVersionsRepo
import com.limitlesscare.doctor.app_versions.domain.model.AppVersionsResponse
import javax.inject.Inject

class AppVersionsRepoImp @Inject constructor(
    private val remoteDataSource: AppVersionsRemoteDataSource
) : AppVersionsRepo {
    override suspend fun getAppVersions(): DataState<AppVersionsResponse> {
        val responseDataState: DataState<AppVersionsResponse> = remoteDataSource.getAppVersions()
        if (responseDataState is DataState.Success) {
            //cache app versions locally
            //localDataSource.setAppVersions(responseDataState.data)
        }
        return responseDataState
    }
}

//private fun sync
//get from remote then set in local


