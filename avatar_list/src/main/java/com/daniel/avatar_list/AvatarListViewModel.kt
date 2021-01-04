package com.daniel.avatar_list

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import base.BaseViewModel
import com.daniel.domain.entity.User
import com.daniel.domain.entity.ViewState
import com.daniel.domain.usecase.GetUsersAvatarsList
import com.daniel.domain.usecase.RemoveUserAvatar
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

class AvatarListViewModel(
    private val getUsersAvatarsList: GetUsersAvatarsList,
    private val removeUserAvatar: RemoveUserAvatar
) : BaseViewModel() {

    private val _usersAvatarListLiveData: MutableLiveData<ViewState<List<User>>> = MutableLiveData()
    val usersAvatarListLiveData: LiveData<ViewState<List<User>>>
        get() = _usersAvatarListLiveData

    init {
        getUsersAvatars()
    }

    private fun getUsersAvatars() = launch {
        getUsersAvatarsList.execute()
            .catch {
                _usersAvatarListLiveData.postValue(ViewState.Error())
            }
            .collect { usersList ->
                _usersAvatarListLiveData.postValue(ViewState.Success(usersList))
            }
    }

    fun removeUser(user: User) = launch {
        removeUserAvatar.execute(user)
                .catch {
                    _usersAvatarListLiveData.postValue(ViewState.Error())
                }
                .collect {
                    getUsersAvatars()
                }
    }
}
