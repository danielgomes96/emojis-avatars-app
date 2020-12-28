package com.daniel.home

import androidx.lifecycle.LiveData
import base.BaseViewModel
import androidx.lifecycle.MutableLiveData
import com.daniel.domain.entity.Emoji
import com.daniel.domain.entity.ViewState
import com.daniel.domain.usecase.GetEmojiListUseCase
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

class HomeViewModel(
    private val getEmojiListUseCase: GetEmojiListUseCase
) : BaseViewModel() {

    private val _emojiListLiveData: MutableLiveData<ViewState<List<Emoji>>> = MutableLiveData()
    val emojiListLiveData: LiveData<ViewState<List<Emoji>>>
        get() = _emojiListLiveData

    fun getEmojiList() = launch {
        _emojiListLiveData.postValue(ViewState.Loading())
        getEmojiListUseCase.execute()
            .catch {
                _emojiListLiveData.postValue(ViewState.Error())
            }
            .collect { emojiList ->
                _emojiListLiveData.postValue(ViewState.Success(emojiList))
            }
    }
}
