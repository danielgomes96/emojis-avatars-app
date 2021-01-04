package com.daniel.data.mapper.remote

import base.BaseMapper
import com.daniel.data.dto.UserDTO
import com.daniel.domain.entity.User

class UserRemoteMapper : BaseMapper<UserDTO, User>() {
    override fun transform(
        entity: UserDTO
    ): User = User(entity.id.toLong(), entity.userName, entity.imageUrl)
}
