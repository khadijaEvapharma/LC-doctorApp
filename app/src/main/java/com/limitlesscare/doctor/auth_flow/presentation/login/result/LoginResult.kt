package com.limitlesscare.doctor.auth_flow.presentation.login.result

import com.limitlesscare.core.Result
import com.limitlesscare.doctor.auth_flow.presentation.login.viewstate.LoginScreenViewState
import com.limitlesscare.doctor.auth_flow.presentation.login.viewstate.LoginViewState

sealed class LoginResult : Result<LoginScreenViewState> {
    data class Login(val viewState: LoginViewState) : LoginResult() {
        override fun reduce(
            defaultState: LoginScreenViewState,
            oldState: LoginScreenViewState
        ): LoginScreenViewState {
            return oldState.copy(loginViewState = viewState)
        }
    }
}
