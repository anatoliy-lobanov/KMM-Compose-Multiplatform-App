package com.lobanov.app.data

import com.lobanov.app.data.posts.PostMapper
import com.lobanov.app.domain.UserDomain
import com.lobanov.app.domain.UserRepository
import com.lobanov.app.domain.posts.UserPostDomain

class UserRepositoryImpl(
    private val userMapper: UserMapper,
    private val postMapper: PostMapper,
    private val userRemoteDataSource: UserRemoteDataSource,
) : UserRepository {

    override suspend fun getUsers(): List<UserDomain> {
        val remoteResponse = userRemoteDataSource.getUsers()
        return userMapper.map(users = remoteResponse)
    }

    override suspend fun getUserPosts(userId: Int): List<UserPostDomain> {
        val remoteResponse = userRemoteDataSource.getUserPosts(userId = userId)
        return postMapper.map(posts = remoteResponse)
    }
}