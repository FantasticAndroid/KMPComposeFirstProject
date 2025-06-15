package deps

import platform.Foundation.NSBundle

@Suppress("EXPECT_ACTUAL_CLASSIFIERS_ARE_IN_BETA_WARNING")
actual class DbClient{
    actual fun getInjectedString(): String {
        return NSBundle.mainBundle.bundleIdentifier ?: "Unknown iOS Bundle"
    }
}