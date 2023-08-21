package com.limitlesscare.doctor.splash_flow.presentation

import android.content.ActivityNotFoundException
import android.content.Context
import android.content.Intent
import android.net.Uri
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.AlertDialog
import androidx.compose.material.Button
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.MaterialTheme
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
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.limitlesscare.doctor.R
import com.limitlesscare.doctor.destinations.LoginScreenDestination
import com.limitlesscare.doctor.destinations.SplashScreenDestination
import com.limitlesscare.doctor.splash_flow.presentation.viewstate.SplashViewState
import com.limitlesscare.doctor.ui.LimitlessTheme
import com.limitlesscare.doctor.ui.Limitless_doctorTheme
import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.annotation.RootNavGraph
import com.ramcosta.composedestinations.navigation.DestinationsNavigator
import com.ramcosta.composedestinations.navigation.EmptyDestinationsNavigator

@RootNavGraph(start = true) // sets this as the start destination of the default nav graph
@Destination
@Composable
fun SplashScreen(
    navigator: DestinationsNavigator
) {
    val viewModel = hiltViewModel<SplashViewModel>()
    val state = viewModel.viewStates.collectAsState()
    SplashScreenContent(state = state.value, navigator)
}

@Composable
private fun SplashScreenContent(
    state: SplashViewState,
    navigator: DestinationsNavigator
) {

    Scaffold(
        modifier = Modifier,
        backgroundColor = LimitlessTheme.colors.primaryVariant,
        bottomBar = {
            Box (modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = dimensionResource(id = R.dimen.padding_42))){
                if (state.isLoading){
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
                .padding(it)
                .fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Row(horizontalArrangement = Arrangement.spacedBy(dimensionResource(id = R.dimen.padding_12))) {
                Image(
                    painter = painterResource(id = R.drawable.logo),
                    contentDescription = "logo of the app"
                )
                Image(
                    painter = painterResource(id = R.drawable.logo_text),
                    contentDescription = "logo of the app"
                )
            }
            Text(
                text = stringResource(id = R.string.new_approch),
                modifier = Modifier.padding(
                    top = dimensionResource(id = R.dimen.padding_16),
                    start = dimensionResource(id = R.dimen.padding_9)
                ),
                color = LimitlessTheme.colors.white,
                style = MaterialTheme.typography.subtitle2,
            )
        }
       // ShowDialogForUpdate(navigator, state)
        navigator.navigate(LoginScreenDestination) {
            popUpTo(SplashScreenDestination.route) {
                inclusive = true
            }
        }

    }
}

@Composable
private fun ShowDialogForUpdate(navigator: DestinationsNavigator, state: SplashViewState) {
    val openDialog = remember { mutableStateOf(true) }
    var softOrForce by remember { mutableStateOf(true) }
    if (state.appVersionDialogState.data?.isSoftUpdate == true) {
        softOrForce = false
    } else if (state.appVersionDialogState.data?.isForceUpdate == true) {
        softOrForce = true
    }
    if (openDialog.value) {
        UpdateAlertDialog(
            navigator = navigator,
            closeDialog = { openDialog.value = false },
            title = stringResource(id = R.string.NEW_UPDATE_AVAILABLE),
            text = stringResource(id = R.string.UPDATE_THE_LATEST_VERSION),
            soft = softOrForce
        )
    }
}

@Composable
fun UpdateAlertDialog(
    navigator: DestinationsNavigator,
    closeDialog: () -> Unit,
    title: String,
    text: String,
    soft: Boolean
) {
    val context = LocalContext.current
    AlertDialog(
        onDismissRequest = {

        },
        title = {
            Text(
                text = title, color = colorResource(id = R.color.black),
                fontWeight = FontWeight.Bold
            )
            
        },
        text = {
            Text(text)
        },
        buttons = {

                Row(
                    modifier = Modifier.padding(all = 8.dp),
                    horizontalArrangement = Arrangement.Center
                ) {
                    if (soft){
                    Button(onClick = { navigateToStore(context) }) {
                        Text(text = stringResource(id = R.string.UPDATE_NOW), color = Color.White)

                    }
                    Button(
                        modifier = Modifier.padding(start = dimensionResource(id = R.dimen.padding_8)),
                        onClick = {
                            closeDialog()
                            navigator.navigate(LoginScreenDestination) {
                                popUpTo(SplashScreenDestination.route) {
                                    inclusive = true
                                }
                            }
                        }
                    ) {
                        Text(stringResource(id = R.string.SKIP), color = Color.White)
                    }
                }else{
                        Button(onClick = { navigateToStore(context) }) {
                            Text(text = stringResource(id = R.string.UPDATE_NOW), color = Color.White)

                        }
                    }
            }

        }
    )
}

private fun navigateToStore(context: Context) {
    try {
        context.startActivity(
            Intent(
                Intent.ACTION_VIEW,
                Uri.parse("market://details?id=com.evapharma.se7etak_for_doctors")
            )
        )
    } catch (e: ActivityNotFoundException) {
        context.startActivity(
            Intent(
                Intent.ACTION_VIEW,
                Uri.parse("https://play.google.com/store/apps/details?id=com.evapharma.se7etak_for_doctors")
            )
        )
    }
}
@Preview(showBackground = true)
@Composable
fun ScreenPreview() {
    Limitless_doctorTheme() {
        SplashScreenContent(state = SplashViewState(), EmptyDestinationsNavigator)
    }
}




