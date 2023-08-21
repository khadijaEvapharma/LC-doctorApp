package com.limitlesscare.doctor.auth_flow.presentation.login

import com.limitlesscare.core.domain.DataState
import com.limitlesscare.core.presentation.viewmodel.MVIBaseViewModel
import com.limitlesscare.doctor.app_core.ext.isValidEmail
import com.limitlesscare.doctor.app_core.ext.isValidPassword
import com.limitlesscare.doctor.auth_flow.domain.model.LoginData
import com.limitlesscare.doctor.auth_flow.domain.usecase.LoginUseCase
import com.limitlesscare.doctor.auth_flow.presentation.login.action.LoginAction
import com.limitlesscare.doctor.auth_flow.presentation.login.result.LoginResult
import com.limitlesscare.doctor.auth_flow.presentation.login.viewstate.LoginScreenViewState
import com.limitlesscare.doctor.auth_flow.presentation.login.viewstate.LoginViewState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.FlowCollector
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(
    private val loginUseCase: LoginUseCase
) : MVIBaseViewModel<LoginAction, LoginResult, LoginScreenViewState>() {
    override val defaultViewState: LoginScreenViewState
        get() = LoginScreenViewState()


    override fun handleAction(action: LoginAction): Flow<LoginResult> {
        return flow {
            when (action) {
                is LoginAction.Login -> {
                    handleLogin(action.data, this)
                }

                is LoginAction.ValidateLogin -> {
                    validateLogin(action.data)
                }
            }
        }
    }

    fun checkDataValidation(loginData: LoginData):Boolean {
        if (!loginData.email.isValidEmail()) {
            emitState {
                it.copy(isEmailError = true)
            }
            return false
        }
        if (!loginData.password.isValidPassword()) {
            emitState {
                it.copy(isPasswordError = true)
            }
            return false
        }
        return true
    }

    private fun validateLogin(loginData: LoginData) {
        emitState {
            it.copy(isButtonEnabled = loginData.email.isNotEmpty() && loginData.password.isNotEmpty())
        }
    }

    private suspend fun handleLogin(
        loginData: LoginData,
        flowCollector: FlowCollector<LoginResult>
    ) {
        if (checkDataValidation(loginData)) {
            flowCollector.emit(LoginResult.Login(LoginViewState(isLoading = true)))
            val dataState = loginUseCase(loginData)
            if (dataState is DataState.Success)
                flowCollector.emit(
                    (LoginResult.Login(LoginViewState(data = true, isSuccess = true)))
                )
            else
                flowCollector.emit(LoginResult.Login(LoginViewState(error = (dataState as DataState.Error).throwable)))
        }
    }
}