package com.daniel.data.repository

import com.daniel.data.database.dao.EmojisDao
import com.daniel.data.mapper.local.EmojiLocalMapper
import com.daniel.data.mapper.remote.EmojiRemoteMapper
import com.daniel.data.service.GithubService
import com.daniel.domain.entity.Emoji
import com.daniel.domain.repository.EmojiRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class EmojiRepositoryImpl(
    private val githubService: GithubService,
    private val emojisDao: EmojisDao
) : EmojiRepository {

    override suspend fun getEmojiList() = flow {
        val shouldFetchFromApi = emojisDao.getEmojiList().isEmpty()
        if (shouldFetchFromApi) {
            saveEmojiList(EmojiRemoteMapper().transform(githubService.getEmojis()))
        }
        emit(
            EmojiLocalMapper().transform(emojisDao.getEmojiList())
        )
    }

    override fun saveEmojiList(emojiList: List<Emoji>) {
        emojisDao.saveEmojiList(
            EmojiLocalMapper().fromDomain(emojiList)
        )
    }

    override fun getRandomEmoji(): Emoji = EmojiLocalMapper()
        .fromLocal(emojisDao.getRandomEmoji())

    override suspend fun hasCache(): Flow<List<Emoji>> = flow {
        emit(
            EmojiLocalMapper().transform(emojisDao.getEmojiList())
        )
    }
}
