package com.limitlesscare.doctor.app_core.ext

import android.app.Activity
import android.app.DatePickerDialog
import android.content.Context
import android.content.ContextWrapper
import android.content.pm.ActivityInfo
import android.content.res.Configuration
import android.util.TypedValue
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.AlertDialog
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.limitlesscare.doctor.R
import com.limitlesscare.doctor.app_core.constants.AppConstants
import com.limitlesscare.doctor.app_core.data.remote.exception.NetworkException
import com.limitlesscare.doctor.app_core.data.remote.exception.UnauthorizedException
import com.limitlesscare.doctor.destinations.LoginScreenDestination
import com.ramcosta.composedestinations.navigation.DestinationsNavigator
import java.util.Calendar
import java.util.Date


fun Context.getAppName(): String = applicationInfo.loadLabel(packageManager).toString()

@Composable
fun Context.handleError(
    throwable: Throwable,
    retryAction: (() -> Unit)? = null
) {
    throwable.printStackTrace()
    val isDialogDisplayed = remember { mutableStateOf(true) }
    val customError = throwable.getCustomException(this)
    if (isDialogDisplayed.value) {
        if (shouldShowNetworkError(customError))
            showErrorDialog(customError, retryAction, closeDialog = {
                isDialogDisplayed.value = false
            })
        else showErrorDialog(customError, null, closeDialog = {
            isDialogDisplayed.value = false
        })
    }
}

fun Context.navigateToLogin(throwable: Throwable, navigator: DestinationsNavigator) {
    val customError = throwable.getCustomException(this)
    if (customError is UnauthorizedException) {
        navigator.navigate(LoginScreenDestination)
    }
}

fun shouldShowNetworkError(throwable: Throwable): Boolean {
    return throwable is NetworkException
}

@Composable
fun showErrorDialog(
    customError: Throwable, retryAction: (() -> Unit)? = null, closeDialog: () -> Unit,
) {
    AlertDialog(
        onDismissRequest = {
            closeDialog()
        },
        title = {
            Text(
                text = stringResource(id = R.string.sorry),
                color = colorResource(id = R.color.black),
                fontWeight = FontWeight.Bold
            )
        },
        text = {
            Text(customError.message ?: customError.localizedMessage)
        },
        buttons = {
            Row(
                modifier = Modifier
                    .padding(all = 8.dp)
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.End
            ) {
                if (retryAction != null) {
                    Button(
                        onClick = { retryAction.invoke() }) {
                        Text(
                            text = stringResource(id = R.string.retry),
                            color = Color.White
                        )
                    }
                } else {
                    Button(
                        onClick = { closeDialog() }) {
                        Text(
                            text = stringResource(id = R.string.ok),
                            color = Color.White
                        )
                    }
                }
            }

        }
    )

}


tailrec fun Context?.activity(): Activity? = this as? Activity
    ?: (this as? ContextWrapper)?.baseContext?.activity()


// extension property to get screen orientation
val Context.orientation: Int
    get() {
        return when (resources.configuration.orientation) {
            Configuration.ORIENTATION_PORTRAIT -> ActivityInfo.SCREEN_ORIENTATION_REVERSE_PORTRAIT
            Configuration.ORIENTATION_LANDSCAPE -> ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE
            else -> ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE
        }
    }


fun Context.showDatePicker(
    currentDate: String = "",
    maxYearsDate: Int = 0,
    minYearsDate: Int = 0,
    dateFormat: String = AppConstants.APP_DATE_PATTERN,
    dateSetListener: (String) -> Unit
) {

    val calendar = Calendar.getInstance()
    if (currentDate.isNotEmpty()) {
        val date: Date = currentDate.stringToDate(dateFormat)
        calendar.time = date
    }

    val datePickerDialog = DatePickerDialog(
        this,
        { view, year, month, dayOfMonth ->
            calendar.set(Calendar.YEAR, year)
            calendar.set(Calendar.MONTH, month)
            calendar.set(Calendar.DAY_OF_MONTH, dayOfMonth)

            val formattedSelectedDate = calendar.time.dateToString(dateFormat)
            dateSetListener.invoke(formattedSelectedDate)
        },

        calendar.get(Calendar.YEAR),
        calendar.get(Calendar.MONTH),
        calendar.get(Calendar.DAY_OF_MONTH)
    )
//    if (maxyearsDate != 0){
    val calendarMax = Calendar.getInstance()
    calendarMax.add(Calendar.YEAR, -maxYearsDate)
    datePickerDialog.datePicker.maxDate = calendarMax.timeInMillis
//    } else {
//        datePickerDialog.datePicker.maxDate = Date().time
//    }
    val calendarMin = Calendar.getInstance()
    calendarMin.add(Calendar.YEAR, -minYearsDate)
    datePickerDialog.datePicker.minDate = calendarMin.timeInMillis
    datePickerDialog.show()
}

fun Context.getActionBarHeight(): Int {
    val tv = TypedValue()
    return if (theme.resolveAttribute(android.R.attr.actionBarSize, tv, true)) {
        TypedValue.complexToDimensionPixelSize(tv.data, resources.displayMetrics)
    } else 0
}