package com.limitlesscare.doctor.app_core.theme

import androidx.compose.material.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import com.limitlesscare.doctor.R

object LimitlessTypography {

    val ibmplex_sans_light = FontFamily(Font(R.font.ibmplex_sans_light))
    val ibmplex_sans_regular = FontFamily(Font(R.font.ibmplex_sans_regular))
    val ibmplex_sans_medium = FontFamily(Font(R.font.ibmplex_sans_medium))
    val typography = Typography(
        h1 = TextStyle().copy(fontFamily = FontFamily(Font(R.font.ibmplex_sans_light))),
        h2 = TextStyle().copy(fontFamily = FontFamily(Font(R.font.ibmplex_sans_light))),
        h3 = TextStyle().copy(fontFamily = FontFamily(Font(R.font.ibmplex_sans_light))),
        h4 = TextStyle().copy(fontFamily = FontFamily(Font(R.font.ibmplex_sans_light))),
        h5 = TextStyle().copy(fontFamily = FontFamily(Font(R.font.ibmplex_sans_light))),
        h6 = TextStyle().copy(
            //     fontSize = Resources.getSystem().getDimension( R.dimen.font_24).sp,
            fontFamily = FontFamily(Font(R.font.ibmplex_sans_light))
        ),
        subtitle1 = TextStyle().copy(fontFamily = FontFamily(Font(R.font.ibmplex_sans_light))),
        subtitle2 = TextStyle().copy(fontFamily = FontFamily(Font(R.font.ibmplex_sans_medium))),
        body1 = TextStyle().copy(fontFamily = FontFamily(Font(R.font.ibmplex_sans_regular))),
        body2 = TextStyle().copy(fontFamily = FontFamily(Font(R.font.ibmplex_sans_regular))),
        button = TextStyle().copy(fontFamily = FontFamily(Font(R.font.ibmplex_sans_medium))),
        caption = TextStyle().copy(fontFamily = FontFamily(Font(R.font.ibmplex_sans_regular))),
        overline = TextStyle().copy(fontFamily = FontFamily(Font(R.font.ibmplex_sans_regular))),
    )

}