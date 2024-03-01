package com.lobanov.app.domain.posts

import com.lobanov.app.domain.UserRepository

class GetUserPostsByIdUseCase(
    private val userRepository: UserRepository,
) {

    suspend fun execute(userId: Int): List<UserPostDomain> {
        return userRepository.getUserPosts(userId = userId)
    }
}