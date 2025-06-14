package com.kmp.first

import oshi.SystemInfo
import kotlin.math.roundToInt

@Suppress("EXPECT_ACTUAL_CLASSIFIERS_ARE_IN_BETA_WARNING")
actual class BatteryInfoProvider {

    actual fun getBatteryLevel(): Int {
        return SystemInfo().hardware.powerSources.firstOrNull()?.remainingCapacityPercent?.times(100)?.roundToInt()?: -1
    }
}