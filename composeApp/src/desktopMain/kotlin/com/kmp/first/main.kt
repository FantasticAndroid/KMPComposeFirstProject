package com.kmp.first

import androidx.compose.runtime.remember
import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application
import di.initKoin
import io.ktor.client.engine.okhttp.OkHttp
import networking.CensorClient
import networking.createHttpClient

fun main() {
    initKoin()
    application {
        Window(
            onCloseRequest = ::exitApplication,
            title = "KMPComposeFirstProject",
        ) {
            /*val batteryInfoProvider = remember { BatteryInfoProvider() }
            App(batteryInfoProvider)*/

            NetworkApp(client = remember { CensorClient(createHttpClient(OkHttp.create())) })

        }
    }
}