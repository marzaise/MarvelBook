package com.marzaise.marvelbook.presentation.heroesList

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.marzaise.marvelbook.R
import com.marzaise.marvelbook.domain.models.HeroModel
import com.marzaise.marvelbook.databinding.ItemHeroBinding

class HeroesAdapter(val detailsClick: ((HeroModel) -> Unit),
                    val favouriteClick: (HeroModel, Boolean) -> Unit) : RecyclerView.Adapter<HeroesAdapter.HeroesViewHolder>() {

    private var data: MutableList<HeroModel> = mutableListOf()

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): HeroesViewHolder {
        val inflater = LayoutInflater.from(parent.context)

        val binding = DataBindingUtil.inflate<ItemHeroBinding>(
            inflater,
            R.layout.item_hero,
            parent,
            false
        )

        return HeroesViewHolder(binding).apply {

            binding.root.setOnClickListener {
                val position = bindingAdapterPosition.takeIf { it != RecyclerView.NO_POSITION }
                    ?: return@setOnClickListener
                detailsClick(data[position])
            }

            binding.ivFavourite.setOnClickListener {
                val position = bindingAdapterPosition.takeIf { it != RecyclerView.NO_POSITION }
                    ?: return@setOnClickListener
                data[position].toggleFavorite()
                favouriteClick(data[position], data[position].isFavorite)
                notifyItemChanged(position)
            }
        }
    }

    override fun getItemCount() = data.size

    override fun onBindViewHolder(holder: HeroesViewHolder, position: Int) //= holder.bind(data[position])
    {
        holder.binding.apply {
            hero = data[position]
            executePendingBindings()
        }
    }

    fun addData(heroesList: List<HeroModel>) {
        val previousItemSize = data.size
        data.addAll(heroesList)
        notifyItemRangeChanged(previousItemSize, data.size)
    }

    inner class HeroesViewHolder(val binding: ItemHeroBinding) : RecyclerView.ViewHolder(binding.root)
}