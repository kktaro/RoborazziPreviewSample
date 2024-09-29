package com.kktaro.roborazzipreviewsample

import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Snackbar
import androidx.compose.material3.SnackbarData
import androidx.compose.material3.SnackbarHostState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun MySnackBar(
    snackbarData: SnackbarData,
) {
    Snackbar(
        snackbarData = snackbarData,
        shape = RoundedCornerShape(16.dp)
    )
}

@Preview
@Composable
private fun MySnackBar_Preview_onlyMessage() {
    val hostState by remember { mutableStateOf(SnackbarHostState()) }

    hostState.currentSnackbarData?.let {
        MySnackBar(it)
    }
    LaunchedEffect(Unit) {
        hostState.showSnackbar(
            message = "Hello, Preview My Snackbar!",
        )
    }
}

@Preview
@Composable
private fun MySnackBar_Preview_withDismiss() {
    val hostState by remember { mutableStateOf(SnackbarHostState()) }

    hostState.currentSnackbarData?.let {
        MySnackBar(it)
    }
    LaunchedEffect(Unit) {
        hostState.showSnackbar(
            message = "Hello, Preview My Snackbar!",
            withDismissAction = true,
        )
    }
}

@Preview
@Composable
private fun MySnackBar_Preview_withAction() {
    val hostState by remember { mutableStateOf(SnackbarHostState()) }

    hostState.currentSnackbarData?.let {
        MySnackBar(it)
    }
    LaunchedEffect(Unit) {
        hostState.showSnackbar(
            message = "Hello, Preview My Snackbar!",
            actionLabel = "Action",
        )
    }
}
