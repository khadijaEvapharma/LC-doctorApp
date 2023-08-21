package com.limitlesscare.doctor.app_core.components

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.limitlesscare.doctor.ui.LimitlessTheme
import kotlinx.coroutines.delay

@Composable
fun CircularProgressCustomDialog(
    open: Boolean
) {
    val openDialog = remember { mutableStateOf(open) }

    DisposableEffect(open) {
        onDispose {
            openDialog.value = false
        }
    }

    if (openDialog.value) {
        LaunchedEffect(true) {
            delay(1000L)
        }

        Surface(
            modifier = Modifier.fillMaxSize(),
            color = Color.Black.copy(alpha = 0.6f) // Semi-transparent background
        ) {
            Box(
                modifier = Modifier.fillMaxSize(),
                contentAlignment = androidx.compose.ui.Alignment.Center
            ) {
                CircularProgressIndicator(
                    modifier = Modifier.size(48.dp),
                    color = LimitlessTheme.colors.primary
                )
            }
        }
    }
}