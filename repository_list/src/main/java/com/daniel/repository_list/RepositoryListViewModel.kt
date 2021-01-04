package com.daniel.repository_list

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import base.BaseViewModel
import com.daniel.domain.entity.Repository
import com.daniel.domain.entity.ViewState
import com.daniel.domain.usecase.GetUserRepositories
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

class RepositoryListViewModel(
    private val getUserRepositories: GetUserRepositories
) : BaseViewModel() {

    private val _repositoriesListLiveData: MutableLiveData<ViewState<List<Repository>>> = MutableLiveData()
    val repositoriesListLiveData: LiveData<ViewState<List<Repository>>>
        get() = _repositoriesListLiveData

    private var currentPage = INITIAL_PAGE
    companion object {
        private const val INITIAL_PAGE = 1
    }

    init {
        fetchRepositories(INITIAL_PAGE)
    }

    private fun fetchRepositories(currentPage: Int) = launch {
        _repositoriesListLiveData.postValue(ViewState.Loading())
        getUserRepositories.execute(currentPage)
            .catch {
                _repositoriesListLiveData.postValue(ViewState.Error())
            }
            .collect {
                _repositoriesListLiveData.postValue(ViewState.Success(it))
            }
    }

    fun shouldLoadMoreItems() {
        currentPage += 1
        fetchRepositories(currentPage)
    }
}
