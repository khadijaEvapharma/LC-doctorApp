package com.limitlesscare.doctor.auth_flow.presentation.login

import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.ClickableText
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.limitlesscare.doctor.R
import com.limitlesscare.doctor.app_core.components.PrimaryButton
import com.limitlesscare.doctor.app_core.components.PrimaryTextField
import com.limitlesscare.doctor.app_core.ext.handleError
import com.limitlesscare.doctor.auth_flow.domain.model.LoginData
import com.limitlesscare.doctor.auth_flow.presentation.login.viewstate.LoginScreenViewState
import com.limitlesscare.doctor.ui.LimitlessTheme
import com.limitlesscare.doctor.ui.Limitless_doctorTheme
import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.navigation.DestinationsNavigator
import com.ramcosta.composedestinations.navigation.EmptyDestinationsNavigator

@Destination
@Composable
fun LoginScreen(
    navigator: DestinationsNavigator
) {
    val viewModel = hiltViewModel<LoginViewModel>()
    val state = viewModel.viewStates.collectAsState()
    LoginScreenContent(navigator, state = state.value, viewModel::validateLogin, viewModel::login)
}

@Composable
fun LoginScreenContent(
    navigator: DestinationsNavigator,
    state: LoginScreenViewState,
    enableButton: (loginData: LoginData) -> Boolean,
    onLoginClicked: (loginData: LoginData) -> Unit,
) {
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var passwordToggle by remember { mutableStateOf(false) }

    Scaffold(
        modifier = Modifier,
        backgroundColor = LimitlessTheme.colors.background,
        bottomBar = {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = dimensionResource(id = R.dimen.padding_42))
            ) {
                if (state.loginViewState.isLoading) {
                    CircularProgressIndicator(
                        modifier = Modifier.align(Alignment.Center),
                        color = LimitlessTheme.colors.primary,
                        backgroundColor = LimitlessTheme.colors.grey,
                    )
                }
            }
        }
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(LimitlessTheme.colors.background)
        ) {
            Row(
                horizontalArrangement = Arrangement.spacedBy(dimensionResource(id = R.dimen.padding_12)),
                modifier = Modifier
                    .background(LimitlessTheme.colors.primaryVariant)
                    .padding(it)
                    .padding(
                        start = dimensionResource(id = R.dimen.padding_20),
                        top = dimensionResource(id = R.dimen.padding_45)
                    )
                    .fillMaxWidth()
            ) {
                Image(
                    painter = painterResource(id = R.drawable.logo), contentDescription = "logo"
                )
                Image(
                    painter = painterResource(id = R.drawable.logo_text),
                    contentDescription = "logo of the app"
                )

            }
            Row(
                modifier = Modifier.padding(
                    start = dimensionResource(id = R.dimen.padding_20),
                    top = dimensionResource(id = R.dimen.padding_35)
                )
            ) {
                Text(
                    text = stringResource(id = R.string.login),
                    color = LimitlessTheme.colors.black,
                    fontSize = 24.sp,
                    fontFamily = FontFamily(Font(R.font.ibmplex_sans_medium)),
                    fontWeight = FontWeight.Bold
                )
            }
            Row(
                modifier = Modifier.padding(
                    start = dimensionResource(id = R.dimen.padding_20),
                    top = dimensionResource(id = R.dimen.padding_13)
                )
            ) {
                Text(
                    text = stringResource(id = R.string.email_address),
                    color = LimitlessTheme.colors.black,
                    fontSize = 14.sp,
                    fontFamily = FontFamily(Font(R.font.ibmplex_sans_medium))
                )
            }
            Row(
                modifier = Modifier
                    .padding(
                        start = dimensionResource(id = R.dimen.padding_20),
                        top = dimensionResource(id = R.dimen.padding_13),
                        end = dimensionResource(id = R.dimen.padding_20)
                    )
                    .fillMaxWidth()


            ) {
                PrimaryTextField(
                    modifier = Modifier.fillMaxWidth(),
                    value = email,
                    singleLine = true,
                    onValueChange = { value: String, error: Boolean ->
                        email = value
                        state.isEmailError = error

                    },
                    isError = state.isEmailError,
                    placeholder = { Text(stringResource(id = R.string.email_address)) },
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email),
                    shape = RoundedCornerShape(50),

                    )
            }
            Text(
                modifier = Modifier.padding(
                    start = dimensionResource(id = R.dimen.padding_20),
                    top = dimensionResource(id = R.dimen.padding_16)
                ),
                text = stringResource(id = R.string.password),
                color = LimitlessTheme.colors.black,
                fontSize = 14.sp,
                fontFamily = FontFamily(Font(R.font.ibmplex_sans_medium))
            )
            PrimaryTextField(
                modifier = Modifier
                    .padding(
                        start = dimensionResource(id = R.dimen.padding_20),
                        top = dimensionResource(id = R.dimen.padding_13),
                        end = dimensionResource(id = R.dimen.padding_20)
                    )
                    .fillMaxWidth(),
                isError = state.isPasswordError,

                trailingIcon = {
                    IconButton(onClick = {
                        passwordToggle = !passwordToggle
                    }) {
                        Icon(
                            painter = if (!passwordToggle) painterResource(id = R.drawable.visibility_24)
                            else painterResource(id = R.drawable.visibility_off_24),
                            contentDescription = "show password",
                        )
                    }
                },
                value = password,
                onValueChange = { value: String, error: Boolean ->
                    password = value
                    state.isPasswordError = error
                },
                singleLine = true,
                placeholder = { Text(stringResource(id = R.string.password)) },
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
                visualTransformation = if (!passwordToggle) PasswordVisualTransformation()
                else VisualTransformation.None,
                shape = RoundedCornerShape(50)
            )
            ClickableText(
                modifier = Modifier
                    .padding(
                        top = dimensionResource(id = R.dimen.padding_13),
                        end = dimensionResource(id = R.dimen.padding_20)
                    )
                    .fillMaxWidth(),
                style = TextStyle(
                    textAlign = TextAlign.End,
                    color = LimitlessTheme.colors.primary,
                    fontSize = 12.sp,
                    fontFamily = FontFamily(Font(R.font.ibmplex_sans_medium))
                ),
                text = AnnotatedString(stringResource(id = R.string.forget_password)),
                onClick = {

                }


            )
            PrimaryButton(
                isEnabled = enableButton(LoginData(email, password)),
                onClick = {
                    onLoginClicked(LoginData(email, password))
                },
                buttonBackground = LimitlessTheme.colors.primary,
                buttonText = stringResource(id = R.string.login),
                textColor = LimitlessTheme.colors.white,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(
                        start = dimensionResource(id = R.dimen.padding_20),
                        end = dimensionResource(id = R.dimen.padding_20),
                        top = dimensionResource(id = R.dimen.padding_25)
                    ),
                testTag = ""
            )
        }
    }
    if (state.loginViewState.error != null) {
        val context = LocalContext.current
        context.handleError(
            throwable = state.loginViewState.error!!
        )
    } else if (state.loginViewState.isSuccess) {
        Toast.makeText(LocalContext.current, "Login successfully", Toast.LENGTH_SHORT).show()
    }

}

@Preview(showBackground = true)
@Composable
fun ScreenPreview() {
    Limitless_doctorTheme() {
        LoginScreenContent(
            EmptyDestinationsNavigator,
            state = LoginScreenViewState(),
            enableButton = { _ ->
                true
            },
            { _ -> }
        )
    }
}