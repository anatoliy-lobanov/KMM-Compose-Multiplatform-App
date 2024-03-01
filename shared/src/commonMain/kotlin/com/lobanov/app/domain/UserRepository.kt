package com.lobanov.app.domain

import com.lobanov.app.domain.posts.UserPostDomain

interface UserRepository {

    suspend fun getUsers(): List<UserDomain>

    suspend fun getUserPosts(userId: Int): List<UserPostDomain>
}