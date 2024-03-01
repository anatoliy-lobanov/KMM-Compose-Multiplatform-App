package com.lobanov.app.di

import com.lobanov.app.data.KtorService
import com.lobanov.app.data.UserMapper
import com.lobanov.app.data.UserRemoteDataSource
import com.lobanov.app.data.UserRepositoryImpl
import com.lobanov.app.data.posts.PostMapper
import com.lobanov.app.domain.GetUsersListUseCase
import com.lobanov.app.domain.UserRepository
import com.lobanov.app.domain.posts.GetUserPostsByIdUseCase
import com.lobanov.app.util.Dispatcher
import com.lobanov.app.util.provideDispatcher
import org.koin.core.module.Module
import org.koin.dsl.module

private fun dataModule() = module {
    factory<UserMapper> {
        UserMapper()
    }

    factory<PostMapper> {
        PostMapper()
    }

    factory<UserRepository> {
        UserRepositoryImpl(
            userMapper = get(),
            userRemoteDataSource = get(),
            postMapper = get(),
        )
    }

    factory<UserRemoteDataSource> {
        UserRemoteDataSource(
            ktorService = get(),
            dispatcher = get(),
        )
    }

    factory<KtorService> {
        KtorService()
    }
}

private fun utilityModule() = module {
    factory<Dispatcher> {
        provideDispatcher()
    }
}

private fun domainModule() = module {
    factory<GetUsersListUseCase> {
        GetUsersListUseCase(
            usersRepository = get(),
        )
    }

    factory<GetUserPostsByIdUseCase> {
        GetUserPostsByIdUseCase(
            userRepository = get(),
        )
    }
}

private fun commonModules() = listOf(
    domainModule(),
    dataModule(),
    utilityModule(),
)

fun getCommonModules(): List<Module> {
    return commonModules()
}