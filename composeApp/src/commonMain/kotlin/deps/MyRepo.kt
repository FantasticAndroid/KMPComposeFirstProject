package deps

interface MyRepo {
    fun getHello() : String
}

/**
 * This is Shared Dependency
 * @property dbClient DbClient
 * @constructor
 */
class MyRepoImpl(private val dbClient: DbClient): MyRepo {

    override fun getHello(): String {
        return dbClient.getInjectedString()
    }
}