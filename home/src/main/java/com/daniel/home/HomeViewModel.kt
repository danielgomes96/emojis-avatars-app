package com.daniel.home

import androidx.lifecycle.LiveData
import base.BaseViewModel
import androidx.lifecycle.MutableLiveData
import com.daniel.domain.entity.Emoji
import com.daniel.domain.entity.User
import com.daniel.domain.entity.ViewState
import com.daniel.domain.usecase.GetEmojiList
import com.daniel.domain.usecase.GetRandomEmoji
import com.daniel.domain.usecase.HasCache
import com.daniel.domain.usecase.SaveEmojiList
import com.daniel.domain.usecase.GetUserDetails
import com.daniel.domain.usecase.SaveUserAvatar
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

class HomeViewModel(
    private val getEmojiList: GetEmojiList,
    private val saveEmojiList: SaveEmojiList,
    private val getUserDetails: GetUserDetails,
    private val saveUserAvatar: SaveUserAvatar,
    private val hasCache: HasCache,
    private val getRandomEmoji: GetRandomEmoji
) : BaseViewModel() {

    private val _hasCacheLiveData: MutableLiveData<List<Emoji>> = MutableLiveData()
    val hasCacheLiveData: LiveData<List<Emoji>>
        get() = _hasCacheLiveData

    private val _emojiListLiveData: MutableLiveData<ViewState<List<Emoji>>> = MutableLiveData()
    val emojiListLiveData: LiveData<ViewState<List<Emoji>>>
        get() = _emojiListLiveData

    private val _randomEmojiLiveData: MutableLiveData<Emoji> = MutableLiveData()
    val randomEmojiLiveData: LiveData<Emoji>
        get() = _randomEmojiLiveData

    private val _userAvatarLiveData: MutableLiveData<ViewState<User>> = MutableLiveData()
    val userAvatarLiveData: LiveData<ViewState<User>>
        get() = _userAvatarLiveData

    init {
        launch {
            hasCache.execute()
                .catch {
                    // TODO: Handle error
                }
                .collect { emojiList ->
                    if (emojiList.isNotEmpty()) _hasCacheLiveData.postValue(emojiList)
                }
        }
    }

    fun getEmojiList() = launch {
        _emojiListLiveData.postValue(ViewState.Loading())
        getEmojiList.execute()
            .catch {
                _emojiListLiveData.postValue(ViewState.Error())
            }
            .collect { emojiList ->
                _emojiListLiveData.postValue(ViewState.Success(emojiList))
            }
    }

    fun saveEmojiList(data: List<Emoji>) = launch {
        saveEmojiList.execute(data)
    }

    fun getRandomEmoji() = launch {
        _randomEmojiLiveData.postValue(getRandomEmoji.execute())
    }

    fun searchUser(userName: String) = launch {
        _userAvatarLiveData.postValue(ViewState.Loading())
        if (userName.isNotEmpty()) {
            getUserDetails.execute(userName)
                .catch {
                    _userAvatarLiveData.postValue(ViewState.Error())
                }
                .collect { userDetails ->
                    _userAvatarLiveData.postValue(ViewState.Success(userDetails))
                    saveUserAvatar.execute(userDetails)
                }
        }
    }
}
