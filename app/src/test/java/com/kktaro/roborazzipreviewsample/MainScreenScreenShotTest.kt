package com.kktaro.roborazzipreviewsample

import androidx.compose.ui.test.junit4.createAndroidComposeRule
import androidx.test.core.app.ActivityScenario
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.github.takahirom.roborazzi.captureRoboImage
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.annotation.GraphicsMode

@RunWith(AndroidJUnit4::class)
@GraphicsMode(GraphicsMode.Mode.NATIVE)
class MainScreenScreenShotTest {
    @get:Rule
    val composeTestRule = createAndroidComposeRule<MainActivity>()

    @Test
    fun captureMainScreen() {
        ActivityScenario.launch(MainActivity::class.java)

        captureRoboImage(
            filePath = "screenshots/${this.javaClass.name}.png",
        ) {
            MainScreen()
        }
    }
}