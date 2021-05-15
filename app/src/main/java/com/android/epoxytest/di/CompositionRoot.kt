package com.android.epoxytest.di

import com.android.epoxytest.ViewModelFactory
import com.android.epoxytest.api.GithubService
import com.android.epoxytest.data.GithubRepository
import com.android.epoxytest.usecase.SearchGithubRepositoryPageUseCase

object CompositionRoot {

    val githubRepository: GithubRepository
        get() = GithubRepository(service = githubService)

    val githubService: GithubService
        get() = GithubService.create()

    val searchGithubRepositoryPageUseCase: SearchGithubRepositoryPageUseCase
        get() = SearchGithubRepositoryPageUseCase(
            repository = githubRepository
        )

    val viewModelFactory = ViewModelFactory(
        searchGithubRepositoryPageUseCase = searchGithubRepositoryPageUseCase
    )

}