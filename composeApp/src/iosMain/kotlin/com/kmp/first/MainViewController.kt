package com.kmp.first

import androidx.compose.runtime.remember
import androidx.compose.ui.window.ComposeUIViewController

fun MainViewController() = ComposeUIViewController {
    val batteryInfoProvider = remember {BatteryInfoProvider()}
    App(batteryInfoProvider)
}