package com.kmp.first

import androidx.compose.runtime.remember
import androidx.compose.ui.window.ComposeUIViewController
import di.initKoin
import io.ktor.client.engine.darwin.Darwin
import networking.CensorClient
import networking.createHttpClient

fun MainViewController() = ComposeUIViewController(configure = {
    initKoin()
}) {
    /*val batteryInfoProvider = remember {BatteryInfoProvider()}
    App(batteryInfoProvider)*/

    NetworkApp(client = remember { CensorClient(createHttpClient(Darwin.create(in))) })

}