package com.lobanov.app.domain.posts

data class UserPostDomain(
    val userId: Int,
    val postId: Int,
    val title: String,
    val body: String,
)