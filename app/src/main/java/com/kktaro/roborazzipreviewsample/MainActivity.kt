package com.kktaro.roborazzipreviewsample

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.kktaro.roborazzipreviewsample.ui.theme.RoborazziPreviewSampleTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        setContent {
            RoborazziPreviewSampleTheme {
                MainScreen()
            }
        }
    }
}
