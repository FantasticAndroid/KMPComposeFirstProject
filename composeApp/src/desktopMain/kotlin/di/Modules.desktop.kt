package di

import org.koin.core.module.dsl.singleOf
import org.koin.dsl.module
import deps.DbClient

actual val platformModule = module {
    singleOf(::DbClient)
}