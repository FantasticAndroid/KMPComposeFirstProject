package deps

import android.content.Context

@Suppress("EXPECT_ACTUAL_CLASSIFIERS_ARE_IN_BETA_WARNING")
actual class DbClient(private val context: Context){

    actual fun getInjectedString(): String {
        return context.packageName
    }
}
//actual class DbClient