package com.limitlesscare.doctor.splash_flow.presentation.result


import com.limitlesscare.core.Result
import com.limitlesscare.doctor.splash_flow.presentation.viewstate.AppVersionDialogState
import com.limitlesscare.doctor.splash_flow.presentation.viewstate.SplashViewState

sealed class SplashResult : Result<SplashViewState> {


    data class VersionsResult(val viewState: AppVersionDialogState) : SplashResult() {
        override fun reduce(
            defaultState: SplashViewState,
            oldState: SplashViewState
        ): SplashViewState {
            return oldState.copy(appVersionDialogState = viewState)
        }
    }

}