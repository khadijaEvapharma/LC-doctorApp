package com.limitlesscare.doctor.splash_flow.presentation

import com.limitlesscare.core.domain.DataState
import com.limitlesscare.core.presentation.viewmodel.MVIBaseViewModel
import com.limitlesscare.doctor.BuildConfig
import com.limitlesscare.doctor.app_versions.domain.model.AppVersionsResponse
import com.limitlesscare.doctor.app_versions.domain.usecases.GetAllAppVersionsUseCase
import com.limitlesscare.doctor.splash_flow.domain.model.VersionsState
import com.limitlesscare.doctor.splash_flow.presentation.action.SplashAction
import com.limitlesscare.doctor.splash_flow.presentation.result.SplashResult
import com.limitlesscare.doctor.splash_flow.presentation.viewstate.AppVersionDialogState
import com.limitlesscare.doctor.splash_flow.presentation.viewstate.SplashViewState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.FlowCollector
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

@HiltViewModel
class SplashViewModel @Inject constructor(
    private val getAllAppVersionsUseCase: GetAllAppVersionsUseCase
) : MVIBaseViewModel<SplashAction, SplashResult, SplashViewState>() {
    private val TAG = "SplashViewModel"
    override val defaultViewState: SplashViewState
        get() = SplashViewState()



    init {
        executeAction(SplashAction.getAppVersions)
    }
     override fun handleAction(action: SplashAction):Flow<SplashResult> {
           return flow{ when (action){
                SplashAction.getAppVersions -> {
                   handleAppVersionsAction(this)
                }
            }
    }
     }


    private suspend fun handleAppVersionsAction(collector: FlowCollector<SplashResult>) {
        collector.emit(SplashResult.VersionsResult(AppVersionDialogState(isLoading = true)))
        val useCaseResponse = getAllAppVersionsUseCase()
        handleAppVersionsUseCaseResponse(useCaseResponse,collector)
    }

    private suspend fun handleAppVersionsUseCaseResponse(
        useCaseResponse: DataState<AppVersionsResponse>,
        collector: FlowCollector<SplashResult>
    ) {

        val isForceUpdated = isForceUpdate(useCaseResponse.data()?.android?.minimumVersion?.toInt())
        val isSoftUpdated = isSoftUpdate(useCaseResponse.data()?.android?.currentVersion?.toInt())
       collector.emit(SplashResult.VersionsResult(AppVersionDialogState(data = VersionsState(isForceUpdated,isSoftUpdated))) )
    }

    private fun isForceUpdate(minVersion: Int?): Boolean {
        if (minVersion == null) return false
        val appVersion = BuildConfig.VERSION_NAME.toDouble().toInt()
        return appVersion < minVersion
    }

    private fun isSoftUpdate(currentVersion: Int?): Boolean {
        if (currentVersion == null) return false
        val appVersion = BuildConfig.VERSION_NAME.toDouble().toInt()
        return appVersion < currentVersion
    }
}