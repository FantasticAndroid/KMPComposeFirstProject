package com.kmp.first

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.safeContentPadding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import deps.MyViewModel
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.ui.tooling.preview.Preview

import kmpcomposefirstproject.composeapp.generated.resources.Res
import kmpcomposefirstproject.composeapp.generated.resources.compose_multiplatform
import kmpcomposefirstproject.composeapp.generated.resources.ic_outline_360
import kmpcomposefirstproject.composeapp.generated.resources.label_battery_level
import org.jetbrains.compose.resources.stringResource
import org.koin.compose.viewmodel.koinViewModel

@Composable
@Preview
fun App(batteryInfoProvider: BatteryInfoProvider) {
    // This will also work
    // val viewModel = koinViewModel<MyViewModel>()

    val viewModel: MyViewModel = koinViewModel()
    MaterialTheme {

        var showContent by remember { mutableStateOf(false) }
        Column(
            modifier = Modifier
                .safeContentPadding()
                .fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            Text(stringResource(Res.string.label_battery_level).plus(batteryInfoProvider.getBatteryLevel()))
            Button(onClick = { showContent = !showContent }) {
                Text("Click me!")
            }
            AnimatedVisibility(showContent) {
                val greeting = remember { Greeting().greet() }
                Column(Modifier.fillMaxWidth(), horizontalAlignment = Alignment.CenterHorizontally) {
                    Image(painterResource(Res.drawable.compose_multiplatform), null)
                    Image(painterResource(Res.drawable.ic_outline_360), null)
                    Text("Compose: $greeting")
                    Text("Inject: ${viewModel.getHelloFromDb()}")
                }
            }
        }
    }
}