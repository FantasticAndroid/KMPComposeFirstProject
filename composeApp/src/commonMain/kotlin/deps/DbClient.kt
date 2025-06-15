package deps

/**
 * This is Platform Specific Dependency
 */
@Suppress("EXPECT_ACTUAL_CLASSIFIERS_ARE_IN_BETA_WARNING")
expect class DbClient{
    fun getInjectedString(): String
}