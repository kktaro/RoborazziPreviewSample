package com.kktaro.roborazzipreviewsample

import com.github.takahirom.roborazzi.ComposePreviewTester
import com.github.takahirom.roborazzi.ExperimentalRoborazziApi
import com.github.takahirom.roborazzi.captureRoboImage
import sergio.sastre.composable.preview.scanner.android.AndroidComposablePreviewScanner
import sergio.sastre.composable.preview.scanner.android.AndroidPreviewInfo
import sergio.sastre.composable.preview.scanner.android.screenshotid.AndroidPreviewScreenshotIdBuilder
import sergio.sastre.composable.preview.scanner.core.preview.ComposablePreview

@OptIn(ExperimentalRoborazziApi::class)
class MyComposePreviewTester : ComposePreviewTester<AndroidPreviewInfo> {
    override fun previews(): List<ComposablePreview<AndroidPreviewInfo>> {
        val options = options()
        return AndroidComposablePreviewScanner()
            .scanPackageTrees(*options.scanOptions.packages.toTypedArray())
            .let {
                if (options.scanOptions.includePrivatePreviews) {
                    it.includePrivatePreviews()
                } else {
                    it
                }
            }
            .getPreviews()
    }

    override fun test(preview: ComposablePreview<AndroidPreviewInfo>) {
        val name = AndroidPreviewScreenshotIdBuilder(preview)
            .ignoreClassName()
            .build()
        val filePath = "screenshots/$name.png"
        preview.captureRoboImage(filePath)
    }
}
