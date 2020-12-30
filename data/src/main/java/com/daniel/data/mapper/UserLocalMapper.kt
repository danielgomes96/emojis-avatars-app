package com.daniel.data.mapper

import base.BaseMapper
import com.daniel.data.database.UserLocal
import com.daniel.domain.entity.User

class UserLocalMapper : BaseMapper<User, UserLocal>() {
    override fun transform(entity: User): UserLocal = UserLocal(entity.id, entity.name, entity.imageUrl)

    fun fromLocal(usersList: List<UserLocal>): List<User> {
        return usersList.map {
            User(it.id, it.userName, it.avatarUrl)
        }
    }
}
