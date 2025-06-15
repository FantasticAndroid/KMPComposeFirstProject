package di

import deps.DbClient
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.module

actual val platformModule = module{
    singleOf(::DbClient)
}