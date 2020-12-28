package com.daniel.data.repository

import com.daniel.data.mapper.EmojiMapper
import com.daniel.data.service.GithubService
import com.daniel.domain.repository.EmojiRepository
import kotlinx.coroutines.flow.flow

class EmojiRepositoryImpl(
    private val githubService: GithubService
) : EmojiRepository {
    override suspend fun getEmojiList() = flow {
        emit(
            EmojiMapper().transform(githubService.getEmojis())
        )
    }
}
