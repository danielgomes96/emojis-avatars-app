package com.daniel.domain.usecase

import com.daniel.domain.entity.Emoji
import kotlinx.coroutines.flow.Flow

interface HasCache {
    suspend fun execute(): Flow<List<Emoji>>
}
