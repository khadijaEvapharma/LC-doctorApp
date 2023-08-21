package com.limitlesscare.doctor.ui

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.MaterialTheme
import androidx.compose.material.MaterialTheme.colors
import androidx.compose.material.darkColors
import androidx.compose.material.lightColors
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.remember
import com.limitlesscare.doctor.app_core.theme.*

object  LimitlessTheme{
val colors: LimitlessColors
    @Composable
    get() = Color.localColors.current
}
@Composable
fun Limitless_doctorTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {

    val colors = if (darkTheme) {
        Color.DarkColorPalette
    } else {
        Color.LightColorPalette

    }
    val limitlessColors = if (darkTheme) {
        Color.limitlessDarkColorPalette
    } else {
        Color.limitlessLightColorPalette

    }


    ProvideLimitlessColors(colors=limitlessColors) {
        MaterialTheme(
            colors = colors,
            typography = LimitlessTypography.typography,
            shapes = LimitlessShapes.shapes,
            content = content
        )
    }

}
@Composable
private fun ProvideLimitlessColors(
    colors: LimitlessColors,
    content: @Composable () -> Unit,
) {

    val limitlessColors = remember { colors }
    limitlessColors.update(colors)
    CompositionLocalProvider(
        Color.localColors provides limitlessColors
        , content = content)

}
