package com.marzaise.marvelbook.presentation.heroDetails

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.marzaise.marvelbook.R
import com.marzaise.marvelbook.databinding.FragmentDetailsHeroBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HeroDetailsFragment : Fragment(R.layout.fragment_details_hero) {
    private val viewModel by viewModels<HeroDetailsViewModel>()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        requireArguments().let {
            HeroDetailsFragmentArgs.fromBundle(it).also { args ->
                viewModel.loadHero(args.hero)
            }
        }

        val binding = FragmentDetailsHeroBinding.bind(view)
        binding.lifecycleOwner = this
        binding.viewModel = viewModel
    }
}