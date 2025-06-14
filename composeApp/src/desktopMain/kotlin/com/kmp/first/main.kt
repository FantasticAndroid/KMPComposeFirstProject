package com.kmp.first

import androidx.compose.runtime.remember
import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application

fun main() = application {
    Window(
        onCloseRequest = ::exitApplication,
        title = "KMPComposeFirstProject",
    ) {
        val batteryInfoProvider = remember {BatteryInfoProvider()}
        App(batteryInfoProvider)
    }
}