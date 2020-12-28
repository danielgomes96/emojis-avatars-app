package com.daniel.home

import androidx.lifecycle.LiveData
import base.BaseViewModel
import androidx.lifecycle.MutableLiveData
import com.daniel.domain.entity.Emoji
import com.daniel.domain.entity.ViewState
import com.daniel.domain.usecase.GetEmojiList
import com.daniel.domain.usecase.GetRandomEmoji
import com.daniel.domain.usecase.SaveEmojiList
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

class HomeViewModel(
    private val getEmojiList: GetEmojiList,
    private val saveEmojiList: SaveEmojiList,
    private val getRandomEmoji: GetRandomEmoji
) : BaseViewModel() {

    private val _emojiListLiveData: MutableLiveData<ViewState<List<Emoji>>> = MutableLiveData()
    val emojiListLiveData: LiveData<ViewState<List<Emoji>>>
        get() = _emojiListLiveData

    private val _randomEmojiLiveData: MutableLiveData<Emoji> = MutableLiveData()
    val randomEmojiLiveData: LiveData<Emoji>
        get() = _randomEmojiLiveData

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
}
