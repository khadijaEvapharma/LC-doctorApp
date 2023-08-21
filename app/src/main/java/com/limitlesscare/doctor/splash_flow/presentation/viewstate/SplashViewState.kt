package com.limitlesscare.doctor.splash_flow.presentation.viewstate

import com.limitlesscare.core.ViewState
import com.limitlesscare.core.presentation.view_state.CommonViewState
import com.limitlesscare.doctor.splash_flow.domain.model.VersionsState


typealias AppVersionDialogState = CommonViewState<VersionsState>

data class SplashViewState(
    val appVersionDialogState: AppVersionDialogState = AppVersionDialogState(),
    val isLoading: Boolean = false
) : ViewState