package com.daniel.home

import base.BaseViewModel
import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.daniel.domain.entity.Emoji
import com.daniel.domain.usecase.GetEmojiListUseCase
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

class HomeViewModel(
    private val getEmojiListUseCase: GetEmojiListUseCase
) : BaseViewModel() {

    var emojiListLv: MutableLiveData<List<Emoji>> = MutableLiveData()

    fun getEmojiList() {
        launch {
            getEmojiListUseCase.execute()
                .catch {
                    Log.e("Error", this.toString())
                }
                .collect { emojiList ->
                    emojiListLv.postValue(emojiList)
                }
        }
    }
}
