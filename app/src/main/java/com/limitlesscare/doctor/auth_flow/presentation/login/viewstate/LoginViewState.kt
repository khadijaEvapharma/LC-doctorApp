package com.limitlesscare.doctor.auth_flow.presentation.login.viewstate

import com.limitlesscare.core.ViewState
import com.limitlesscare.core.presentation.view_state.CommonViewState

typealias LoginViewState = CommonViewState<Boolean>

data class LoginScreenViewState(
    val loginViewState: LoginViewState = LoginViewState(),
    var isEmailError: Boolean = false,
    var isPasswordError: Boolean = false
) : ViewState