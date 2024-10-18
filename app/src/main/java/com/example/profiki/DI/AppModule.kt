package com.example.profiki.DI

import com.example.profiki.Data.Model.PokemonResponse
import com.example.profiki.Data.PokeApi
import com.example.profiki.Data.PokeApiImpl
import com.example.profiki.Data.PokeService
import com.example.profiki.Data.Repository.PokeRepository
import com.example.profiki.ui.UI.Pokedex.PokeViewModel
import com.example.profiki.ui.UI.Pokemons.PokeAboutViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val appModule = module {

    single<PokeApi> { PokeService.service }

    single { PokeApiImpl(get()) }

    single { PokeRepository(get()) }

    viewModel { PokeViewModel(get()) }

    viewModel { (pokemonList: List<PokemonResponse>) ->
        PokeAboutViewModel(get(), pokemonList)
    }
}