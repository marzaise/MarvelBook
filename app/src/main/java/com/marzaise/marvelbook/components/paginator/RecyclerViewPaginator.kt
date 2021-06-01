package com.marzaise.recipesbook.components.paginator

import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class RecyclerViewPaginator(
    recyclerView: RecyclerView,
    private val loadMore: (Int) -> Unit
) : RecyclerView.OnScrollListener() {

    private val threshold: Int = 8
    private var currentPage: Int = 1
    private var lastVisibleItem: Int = 0

    private var totalItemCount: Int = 0
    private var lastTotalItemCount: Int = 0

    init {
        recyclerView.addOnScrollListener(this)
    }

    override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
        super.onScrolled(recyclerView, dx, dy)

        val mLayoutManager = recyclerView.layoutManager
        totalItemCount = mLayoutManager!!.itemCount

        lastVisibleItem = (mLayoutManager as LinearLayoutManager).findLastVisibleItemPosition()

        if (totalItemCount > lastTotalItemCount && totalItemCount <= lastVisibleItem + threshold) {
            loadMore(++currentPage)
            lastTotalItemCount = totalItemCount
        }
    }
}