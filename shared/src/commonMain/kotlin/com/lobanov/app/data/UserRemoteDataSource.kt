package com.lobanov.app.data

import com.lobanov.app.data.posts.PostDto
import com.lobanov.app.util.Dispatcher
import io.ktor.client.call.body
import io.ktor.client.request.get
import kotlinx.coroutines.withContext

class UserRemoteDataSource(
    private val ktorService: KtorService,
    private val dispatcher: Dispatcher,
) {

    suspend fun getUsers(): List<UserDto> {
        return withContext(dispatcher.io) {
            ktorService.client.get("$BASE_URL/users").body()
        }
    }

    suspend fun getUserPosts(userId: Int): List<PostDto> {
        return withContext(dispatcher.io) {
            ktorService.client.get("$BASE_URL/posts?userId=$userId").body()
        }
    }
}