package com.kmp.first

@Suppress("EXPECT_ACTUAL_CLASSIFIERS_ARE_IN_BETA_WARNING")
expect class BatteryInfoProvider {
    fun getBatteryLevel(): Int
}