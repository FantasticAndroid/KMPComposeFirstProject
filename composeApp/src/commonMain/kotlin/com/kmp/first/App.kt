package com.kmp.first

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeContentPadding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import deps.MyViewModel
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.ui.tooling.preview.Preview

import kmpcomposefirstproject.composeapp.generated.resources.Res
import kmpcomposefirstproject.composeapp.generated.resources.compose_multiplatform
import kmpcomposefirstproject.composeapp.generated.resources.ic_outline_360
import kmpcomposefirstproject.composeapp.generated.resources.label_battery_level
import kotlinx.coroutines.launch
import networking.CensorClient
import networking.util.NetworkError
import networking.util.map
import networking.util.onError
import networking.util.onSuccess
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

@Composable
@Preview
fun NetworkApp(client: CensorClient) {
    MaterialTheme {
        var censoredText by remember { mutableStateOf<String?>(null) }
        var uncensoredText by remember { mutableStateOf("") }
        var isLoading by remember { mutableStateOf(false) }
        var error by remember { mutableStateOf<NetworkError?>(null) }

        val scope = rememberCoroutineScope()
        Column(
            modifier = Modifier
                .fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(16.dp, Alignment.CenterVertically)
        ) {
            TextField(
                value = uncensoredText,
                onValueChange = { uncensoredText = it },
                label = { Text("Enter Text") },
                modifier = Modifier.padding(16.dp).fillMaxWidth(),
                placeholder = {
                    Text("Uncensored Text here")
                }
            )

            Button(onClick = {
                scope.launch {
                    isLoading = true
                    error = null
                    client.censorWords(uncensoredText)
                        .onSuccess {
                            censoredText =  it
                        }
                        .onError {
                            error = it as NetworkError
                        }.map {
                            censoredText = it
                            isLoading = false
                        }
                    isLoading = false
                }
            }){
                if(isLoading){
                    CircularProgressIndicator(modifier = Modifier.size(16.dp),
                        strokeWidth = 1.dp,
                        color = Color.White)
                }else {
                    Text("Do Censor!")
                }
            }
            censoredText?.let {
                Text(it)
            }
            error?.let {
                Text(
                    text = it.name,
                    color = Color.Red
                )
            }
        }
    }
}