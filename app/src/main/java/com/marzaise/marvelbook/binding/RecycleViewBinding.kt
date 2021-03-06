package com.marzaise.marvelbook.binding

import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.marzaise.marvelbook.components.paginator.PaginatorListener
import com.marzaise.marvelbook.components.paginator.RecyclerViewPaginator
import com.marzaise.marvelbook.domain.models.HeroModel
import com.marzaise.marvelbook.presentation.heroesList.HeroesAdapter

object RecycleViewBinding {
    @JvmStatic
    @BindingAdapter("adapter")
    fun bindAdapter(view: RecyclerView, adapter: RecyclerView.Adapter<*>) {
        view.adapter = adapter
        view.itemAnimator = null
    }

    @JvmStatic
    @BindingAdapter("heroesListLiveData")
    fun bindAdapterHeroesList(view: RecyclerView, heroesList: List<HeroModel>?) {
        (view.adapter as HeroesAdapter).addData(heroesList ?: arrayListOf())
    }

    @JvmStatic
    @BindingAdapter("paginator")
    fun paginator(view: RecyclerView, paginator: PaginatorListener) {
        RecyclerViewPaginator(
            recyclerView = view,
            loadMore = { paginator.loadNewPage() }
        )
    }
}
