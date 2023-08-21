package com.limitlesscare.doctor.app_core.theme

import android.annotation.SuppressLint
import androidx.compose.material.darkColors
import androidx.compose.material.lightColors
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.graphics.Color

object Color {
    val localColors = staticCompositionLocalOf<LimitlessColors> {
        error("No limitlessColorPalette provided")
    }

    private val neutral200 = Color(0xFFE5E7EB)
    private val neutral200Dark = Color(0xFF332D44)

    private val neutral300 = Color(0xFFD1D5DB)
    private val neutral300Dark = Color(0xFF423D53)

    private val neutral400 = Color(0xFF9CA3AF)
    private val neutral400Dark = Color(0xFFCCCCCC)

    private val neutral600 = Color(0xFF4B5563)
    private val neutral600Dark = Color(0xFFCCCCCC)

    private val white = Color(0xFFFFFFFF)
    private val whiteDark = Color(0x0DFFFFFF)

    private val blackSolid = Color(0xFF000000)
    private val blackSolidDark = Color(0xFF000000)

    private val whiteSolid = Color(0xFFFFFFFF)
    private val whiteSolidDark = Color(0xFFFFFFFF)

    private val black = Color(0xFF000000)
    private val blackDark = Color(0xFFFFFFFF)

    private val primary = Color(0xFF9164CC)
    private val primaryDark = Color(0xFF9164CC)

    private val primaryVariant = Color(0xFF21145F)
    private val primaryVariantDark = Color(0xFF131218)

    private val shades700 = Color(0xFF472673)
    private val shades700Dark = Color(0xFFFFFFFF)

    private val primaryShades100 = Color(0xFFE4D9F2)
    private val primaryShades100Dark = Color(0xFFCBB5E7)

    private val background = Color(0xFFF9FAFB)
    private val backgroundDark = Color(0xFF1C1921)
    private val screenBackground = Color(0xFFEAEAEA)

    val error = Color(0xFFEF4444)
    private val errorDark = Color(0xFFFB7171)

    val success = Color(0xFF2FBC4B)
    private val successDark = Color(0xFF64EA92)

    val warning = Color(0xFFFCD34D)
    private val warningDark = Color(0xFFFFDF75)

    private val shimmer = Color(0xFFE4E3E2)
    private val shimmerDark = Color(0xFFE4E3E2)

    private val MainPurpleDark = Color(0xFF2C2966)
    private val MainPurpleLight = Color(0xFF8E67CD)
    private val Grey = Color(0xFFD0D6E4)
    private val Green = Color(0xFFC2E3E7)
    private val ExtraLightPurple = Color(0xFFD4C6EE)

    // limitless Theme Colors
    val limitlessLightColorPalette = LimitlessColors(
        grey = Grey,
        green = Green,
        extraLightPurple = ExtraLightPurple,
        white = white,
        whiteSolid = whiteSolid,
        black = black,
        blackSolid = blackSolid,
        primary = MainPurpleLight,
        primaryVariant = MainPurpleDark,
        shades700 = shades700,
        primaryShades100 = primaryShades100,
        background = screenBackground,
        error = error,
        success = success,
        warning = warning,
        shimmer = shimmer,
        disabled = neutral200,
        isDark = false,
    )

    val limitlessDarkColorPalette = LimitlessColors(
        grey = Grey,
        green = Green,
        extraLightPurple = ExtraLightPurple,
        white = whiteDark,
        whiteSolid = whiteSolidDark,
        black = blackDark,
        blackSolid = blackSolidDark,
        primary = primaryDark,
        primaryVariant = primaryVariantDark,
        shades700 = shades700Dark,
        primaryShades100 = primaryShades100Dark,
        background = backgroundDark,
        error = errorDark,
        success = successDark,
        warning = warningDark,
        shimmer = shimmerDark,
        disabled = neutral200,
        isDark = true,
    )
    // Native MaterialTheme Colors
    val LightColorPalette = lightColors(
        primary = primary,
        primaryVariant = primaryVariant,
        secondary = primary,
        secondaryVariant = primaryVariant,

        background = background,
        surface = background,

        error = error,
        onPrimary = backgroundDark,

        onSecondary = backgroundDark,
        onBackground = backgroundDark,
        onSurface = backgroundDark,

        onError = background,
    )
    @SuppressLint("ConflictingOnColor")
    val DarkColorPalette = darkColors(
        primary = primaryDark,
        primaryVariant = primaryDark,
        secondary = primaryDark,
        secondaryVariant = primaryVariantDark,
        error = error,
        background = backgroundDark,
        surface = backgroundDark,
        onPrimary = backgroundDark,

        onError = backgroundDark,
        onSecondary = background,
        onBackground = background,
        onSurface = background,
    )
}