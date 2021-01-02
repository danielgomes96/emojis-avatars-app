package com.daniel.repository_list

import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

internal class PaginationListener(
    private val layoutManager: LinearLayoutManager,
    private var isLastPage: Boolean,
    private val loadMoreItems: () -> Unit
) : RecyclerView.OnScrollListener() {

    private var isLoading = false

    internal fun updateEndScrollState(isLastPage: Boolean) {
        this.isLastPage = isLastPage
        isLoading = false
    }

    override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
        super.onScrolled(recyclerView, dx, dy)
        val visibleItemCount = layoutManager.childCount
        val totalItemCount = layoutManager.itemCount
        val firstVisibleItemPosition = layoutManager.findFirstVisibleItemPosition()

        if (isLoading.not() && isLastPage.not()) {
            if ((visibleItemCount + firstVisibleItemPosition) >= totalItemCount) {
                isLoading = true
                loadMoreItems()
            }
        }
    }
}
