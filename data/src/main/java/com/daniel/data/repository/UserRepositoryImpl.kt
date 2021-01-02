package com.daniel.data.repository

import com.daniel.data.database.dao.UsersDao
import com.daniel.data.mapper.local.UserLocalMapper
import com.daniel.data.mapper.remote.UserRemoteMapper
import com.daniel.data.service.GithubService
import com.daniel.domain.entity.User
import com.daniel.domain.repository.UserRepository
import kotlinx.coroutines.flow.flow

class UserRepositoryImpl(
    private val githubService: GithubService,
    private val usersDao: UsersDao
) : UserRepository {
    override suspend fun getUserDetails(userName: String) = flow {
        emit(
            UserRemoteMapper().transform(githubService.getUserDetails(userName))
        )
    }

    override suspend fun saveUserAvatar(user: User) {
        usersDao.saveUser(
            UserLocalMapper().transform(user)
        )
    }

    override suspend fun getUserAvatarList() = flow {
        emit(
            UserLocalMapper().fromLocal(usersDao.getUsersList())
        )
    }

    override suspend fun removeUserAvatar(user: User) = flow {
        emit(
            usersDao.removeUser(
                UserLocalMapper().transform(user).id)
        )
    }
}
