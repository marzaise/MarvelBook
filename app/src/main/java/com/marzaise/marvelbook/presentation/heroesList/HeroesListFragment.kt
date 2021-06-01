package com.marzaise.marvelbook.presentation.heroesList

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.marzaise.marvelbook.R
import com.marzaise.marvelbook.domain.usecases.GetMarvelListUseCase
import javax.inject.Inject

class HeroesListFragment @Inject constructor(private val getMarvelListUseCase: GetMarvelListUseCase) : Fragment(R.layout.fragment_list_heroes){

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }
}