package com.lobanov.app.data

import com.lobanov.app.domain.UserDomain

class UserMapper {

    fun map(users: List<UserDto>): List<UserDomain> {
        return users.map { user -> mapUser(dto = user) }
    }

    private fun mapUser(dto: UserDto): UserDomain {
        return UserDomain(
            id = dto.id,
            name = dto.name,
        )
    }
}