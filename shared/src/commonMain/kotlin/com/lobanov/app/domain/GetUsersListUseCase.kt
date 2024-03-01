package com.lobanov.app.domain

class GetUsersListUseCase(
    private val usersRepository: UserRepository,
) {

    suspend fun execute(): List<UserDomain> {
        return usersRepository.getUsers()
    }
}