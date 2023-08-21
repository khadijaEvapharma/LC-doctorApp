package com.limitlesscare.doctor.app_core.theme

import android.content.res.Resources
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Shapes
import androidx.compose.ui.unit.dp
import com.limitlesscare.doctor.R

object LimitlessShapes {

    val shapes= Shapes(
        small = RoundedCornerShape(8.dp),
        medium = RoundedCornerShape(15.dp),
        large = RoundedCornerShape(20.dp)
    )
}