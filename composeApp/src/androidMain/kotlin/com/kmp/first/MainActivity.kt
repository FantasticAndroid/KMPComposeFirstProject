package com.kmp.first

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.tooling.preview.Preview
import io.ktor.client.engine.okhttp.OkHttp
import io.ktor.client.engine.okhttp.OkHttpEngine
import networking.CensorClient
import networking.createHttpClient

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        enableEdgeToEdge()
        super.onCreate(savedInstanceState)

        setContent {

            /*val batteryInfoProvider = remember {BatteryInfoProvider(applicationContext)}
            App(batteryInfoProvider)*/

            NetworkApp(client = remember { CensorClient(createHttpClient(OkHttp.create())) })

        }
    }
}