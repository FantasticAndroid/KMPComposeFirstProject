package com.kmp.first

import androidx.compose.runtime.remember
import androidx.compose.ui.window.ComposeUIViewController
import di.initKoin

fun MainViewController() = ComposeUIViewController(configure = {
    initKoin()
}) {
    val batteryInfoProvider = remember {BatteryInfoProvider()}
    App(batteryInfoProvider)
}