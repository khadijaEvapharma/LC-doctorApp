package com.limitlesscare.doctor.auth_flow.presentation.login.action

import com.limitlesscare.core.Action
import com.limitlesscare.doctor.auth_flow.domain.model.LoginData

sealed class LoginAction : Action {
    data class Login(val data: LoginData) : LoginAction()
}
