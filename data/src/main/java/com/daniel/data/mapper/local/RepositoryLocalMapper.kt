package com.daniel.data.mapper.local

import base.BaseMapper
import com.daniel.data.database.entity.RepositoryLocal
import com.daniel.data.dto.RepositoryDTO
import com.daniel.domain.entity.Repository

class RepositoryLocalMapper : BaseMapper<List<RepositoryLocal>, List<Repository>>() {

    override fun transform(
        entity: List<RepositoryLocal>
    ): List<Repository> {
        return entity.map {
            Repository(it.id, it.name)
        }
    }

    fun fromRemote(entity: List<RepositoryDTO>, page: Int): List<RepositoryLocal> {
        return entity.map {
            RepositoryLocal(it.id, page, it.name)
        }
    }
}
