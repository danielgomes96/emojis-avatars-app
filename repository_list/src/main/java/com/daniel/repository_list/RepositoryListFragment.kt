package com.daniel.repository_list

import Consts.PAGE_SIZE_REPOSITORY_LIST
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.daniel.domain.entity.Repository
import com.daniel.domain.entity.ViewState
import com.daniel.repository_list.databinding.FragmentRepositoryListBinding
import com.daniel.repository_list.di.repositoryListModule
import extension.showToast
import extension.viewBinding
import org.koin.androidx.viewmodel.ext.android.viewModel
import org.koin.core.context.loadKoinModules
import org.koin.core.context.unloadKoinModules

class RepositoryListFragment : Fragment(R.layout.fragment_repository_list) {

    private val viewModel by viewModel<RepositoryListViewModel>()
    private val repositoryListViewBinding by viewBinding(FragmentRepositoryListBinding::bind)
    private val repositoryListAdapter by lazy {
        RepositoryListAdapter()
    }

    private val paginationListener: PaginationListener by lazy {
        PaginationListener(
            layoutManager = repositoryListViewBinding.fragmentRepositoryList.layoutManager as LinearLayoutManager,
            isLastPage = false,
            loadMoreItems = ::loadMoreItems
        )
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        loadKoinModules(repositoryListModule)
        setupRecyclerView()
        setupObservers()
    }

    private fun setupObservers() {
        viewModel.repositoriesListLiveData.observe(viewLifecycleOwner, Observer { viewState ->
            when (viewState) {
                is ViewState.Success -> {
                    displayRepositoryList(viewState.data)
                }
                is ViewState.Error -> {
                    displayError()
                }
                is ViewState.Loading -> {
                    repositoryListAdapter.updateFooter(true)
                }
            }
        })
    }

    private fun displayError() {
        repositoryListAdapter.updateFooter(false)
        context?.showToast(getString(R.string.error_repositories_response))
        paginationListener.updateEndScrollState(repositoryListAdapter.itemCount < PAGE_SIZE_REPOSITORY_LIST)
    }

    private fun displayRepositoryList(list: List<Repository>) {
        repositoryListAdapter.updateFooter(false)
        repositoryListAdapter.submitData(list)
        paginationListener.updateEndScrollState(list.size < PAGE_SIZE_REPOSITORY_LIST)
    }

    private fun setupRecyclerView() = with(repositoryListViewBinding.fragmentRepositoryList) {
        adapter = repositoryListAdapter
        addOnScrollListener(paginationListener)
    }

    private fun loadMoreItems() {
        viewModel.shouldLoadMoreItems()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        unloadKoinModules(repositoryListModule)
    }
}
