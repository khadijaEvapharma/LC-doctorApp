package com.limitlesscare.doctor

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.limitlesscare.doctor.ui.Limitless_doctorTheme
import com.ramcosta.composedestinations.DestinationsNavHost
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Limitless_doctorTheme {
                DestinationsNavHost(navGraph = NavGraphs.root)
            }
        }
    }
}


@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    Limitless_doctorTheme {
         // SplashScreen()
    }
}