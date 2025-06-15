package di

import deps.MyViewModel
import deps.MyRepo
import deps.MyRepoImpl
import org.koin.core.module.Module
import org.koin.core.module.dsl.viewModelOf
import org.koin.dsl.bind
import org.koin.dsl.module

val sharedModule = module {
    single { MyRepoImpl(get()) }.bind<MyRepo>()
    viewModelOf(::MyViewModel)
}

expect val platformModule: Module

