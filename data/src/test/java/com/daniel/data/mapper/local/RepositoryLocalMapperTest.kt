package com.daniel.data.mapper.local

import com.daniel.data.database.entity.RepositoryLocal
import com.daniel.domain.entity.Repository
import junit.framework.TestCase
import org.junit.Test

class RepositoryLocalMapperTest {
    private companion object {
        val FAKE_REPOSITORY_LOCAL_LIST = listOf<RepositoryLocal>(
                RepositoryLocal(0, 0, "emoji-app-avatars1"),
                RepositoryLocal(1, 0, "emoji-app-avatars2"),
                RepositoryLocal(2, 0, "emoji-app-avatars3")
        )
        val FAKE_REPOSITORY_LIST = listOf<Repository>(
                Repository(0, "emoji-app-avatars1"),
                Repository(1, "emoji-app-avatars2"),
                Repository(2, "emoji-app-avatars3")
        )
    }
    private val repositoryMapper by lazy {
        RepositoryLocalMapper()
    }

    @Test
    fun `GIVEN a local repository list WHEN transforming it THEN get proper repository list object`() {
        // Given
        // When
        val repositoryList = repositoryMapper.transform(FAKE_REPOSITORY_LOCAL_LIST)

        // Then
        TestCase.assertEquals(FAKE_REPOSITORY_LIST, repositoryList)
    }
}
