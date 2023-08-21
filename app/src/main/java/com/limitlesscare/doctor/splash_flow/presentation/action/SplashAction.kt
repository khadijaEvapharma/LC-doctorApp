package com.limitlesscare.doctor.splash_flow.presentation.action

import com.limitlesscare.core.Action

sealed class SplashAction : Action {

//    object getConfigurationVersion: SplashAction()
//    object setConfigurationVersion: SplashAction()
    object getAppVersions :SplashAction()
}
