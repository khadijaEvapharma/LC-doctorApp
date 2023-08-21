package com.limitlesscare.doctor.app_core.components

import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.keyframes
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.semantics.contentDescription
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.limitlesscare.doctor.app_core.theme.LimitlessTypography
import com.limitlesscare.doctor.ui.LimitlessTheme
import com.limitlesscare.doctor.ui.Limitless_doctorTheme

@Composable
fun PrimaryButton(
    modifier: Modifier = Modifier,
    buttonText: String,
    testTag: String,
    padding: Int = 0,
    textColor: Color = LimitlessTheme.colors.black,
    fontFamily: FontFamily = LimitlessTypography.ibmplex_sans_regular,
    buttonBackground: Color = LimitlessTheme.colors.background,
    circularProgressIndicatorColor: Color = Color.White,
    progress: Float = 0.2f,
    isEnabled: Boolean,
    showLoader: Boolean = false,
    height: Dp = 50.dp,
    onClick: () -> (Unit)
) {
    Button(
        onClick = onClick,
        enabled = isEnabled,
        elevation = ButtonDefaults.elevation(
            defaultElevation = 0.dp,
            disabledElevation = 0.dp,
            focusedElevation = 0.dp,
            hoveredElevation = 0.dp,
            pressedElevation = 0.dp
        ),
        modifier = modifier
            .semantics { contentDescription = testTag }
            .padding(horizontal = padding.dp)
            .fillMaxWidth()
            .height(height)
            .testTag(testTag),
        colors = ButtonDefaults.buttonColors(
            backgroundColor = buttonBackground
        ),
        shape = RoundedCornerShape(28.dp),
    ) {
        val infiniteTransition = rememberInfiniteTransition()
        val loaderAngle by infiniteTransition.animateFloat(
            initialValue = 0F,
            targetValue = 360F,
            animationSpec = infiniteRepeatable(animation = keyframes { durationMillis = 600 }),
        )

        if (showLoader) {
            //show loader inside the button
            CircularProgressIndicator(
                modifier = Modifier
                    .width(24.dp)
                    .height(24.dp)
                    .graphicsLayer {
                        rotationZ = loaderAngle
                    },
                progress = progress,
                strokeWidth = 2.dp,
                color = circularProgressIndicatorColor
            )

        } else {
            // show text on the  button
            Text(
                text = buttonText,
                modifier = Modifier.fillMaxWidth(),
                color = if (isEnabled) textColor else LimitlessTheme.colors.white,
                style = TextStyle(
                    fontFamily = fontFamily,
                    textAlign = TextAlign.Center,
                    fontSize = 14.sp
                )


            )

        }
    }
}

@Preview
@Composable
fun ButtonPreview() {
    Limitless_doctorTheme {
        PrimaryButton(buttonText = "Click", isEnabled = true, testTag = "") {

        }
    }
}
