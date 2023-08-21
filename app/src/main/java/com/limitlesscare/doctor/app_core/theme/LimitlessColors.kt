package com.limitlesscare.doctor.app_core.theme

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.ui.graphics.Color

class LimitlessColors(
    grey:Color,
    green:Color,
    extraLightPurple:Color,
    white: Color,
    whiteSolid: Color,
    black: Color,
    blackSolid: Color,
    primary: Color,
    primaryVariant: Color,
    shades700: Color,
    primaryShades100: Color,
    background: Color,
    error: Color,
    success: Color,
    warning: Color,
    shimmer: Color,
    disabled: Color,
    isDark: Boolean,
) {
    var grey by mutableStateOf(grey)
        private set
    var green by mutableStateOf(green)
        private set
    var extraLightPurple by mutableStateOf(extraLightPurple)
        private set
    var white by mutableStateOf(white)
        private set
    var whiteSolid by mutableStateOf(whiteSolid)
        private set
    var black by mutableStateOf(black)
        private set
    var blackSolid by mutableStateOf(blackSolid)
        private set
    var primary by mutableStateOf(primary)
        private set
    var primaryVariant by mutableStateOf(primaryVariant)
        private set
    var shades700 by mutableStateOf(shades700)
        private set
    var primaryShades100 by mutableStateOf(primaryShades100)
        private set
    var background by mutableStateOf(background)
        private set
    var error by mutableStateOf(error)
        private set
    var success by mutableStateOf(success)
        private set
    var warning by mutableStateOf(warning)
        private set
    var shimmer by mutableStateOf(shimmer)
        private set
    var disabled by mutableStateOf(disabled)
        private set

    var isDark by mutableStateOf(isDark)
        private set

    fun update(limitlessColors: LimitlessColors) {
        grey = limitlessColors.grey
        green = limitlessColors.green
        extraLightPurple = limitlessColors.extraLightPurple
        white = limitlessColors.white
        whiteSolid = limitlessColors.whiteSolid
        black = limitlessColors.black
        blackSolid = limitlessColors.blackSolid
        primary = limitlessColors.primary
        primaryVariant = limitlessColors.primaryVariant
        shades700 = limitlessColors.shades700
        primaryShades100 = limitlessColors.primaryShades100
        background = limitlessColors.background
        error = limitlessColors.error
        success = limitlessColors.success
        warning = limitlessColors.warning
        shimmer = limitlessColors.shimmer
        background = limitlessColors.background
        disabled = limitlessColors.disabled
        isDark = limitlessColors.isDark
    }

    fun copy(): LimitlessColors = LimitlessColors(
        grey = grey,
        green=green,
        extraLightPurple=extraLightPurple,
        white = white,
        whiteSolid = whiteSolid,
        black = black,
        blackSolid = blackSolid,
        primary = primary,
        primaryVariant = primaryVariant,
        shades700 = shades700,
        primaryShades100 = primaryShades100,
        background = background,
        error = error,
        success = success,
        warning = warning,
        shimmer = shimmer,
        disabled = disabled,
        isDark = isDark,
    )

}
