package com.kmp.first

import platform.UIKit.UIDevice
import kotlin.math.roundToInt

@Suppress("EXPECT_ACTUAL_CLASSIFIERS_ARE_IN_BETA_WARNING")
actual class BatteryInfoProvider {

    actual fun getBatteryLevel(): Int {
        UIDevice.currentDevice.batteryMonitoringEnabled = true
        return (UIDevice.currentDevice.batteryLevel * 100f).roundToInt()
    }
}