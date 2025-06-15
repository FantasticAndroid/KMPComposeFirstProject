package deps

import com.kmp.first.main

@Suppress("EXPECT_ACTUAL_CLASSIFIERS_ARE_IN_BETA_WARNING")
actual class DbClient{

    actual fun getInjectedString(): String {
        return object {}.javaClass.packageName
    }
}