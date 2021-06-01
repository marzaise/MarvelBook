package com.marzaise.marvelbook.presentation.heroesList

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.marzaise.marvelbook.R
import com.marzaise.marvelbook.domain.models.HeroModel
import com.marzaise.marvelbook.databinding.FragmentListHeroesBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HeroesListFragment : Fragment(R.layout.fragment_list_heroes){
    private val viewModel by viewModels<HeroesListViewModel>()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val binding = FragmentListHeroesBinding.bind(view)
        binding.lifecycleOwner = this
        binding.viewModel = viewModel
        binding.adapter = HeroesAdapter({ hero -> gotToHero(hero) }, {hero, isFavourite -> favoriteHero(hero, isFavourite)})

        viewModel.loadHeroes()
    }

    private fun gotToHero(hero: HeroModel){
        val action = HeroesListFragmentDirections.actionListFragmentToDetailsFragment(hero)
        findNavController().navigate(action)
    }

    private fun favoriteHero(hero: HeroModel, isFavorite: Boolean){
        viewModel.setHeroFavourite(hero, isFavorite)
    }
}