package com.android.epoxytest.di

import com.android.epoxytest.ViewModelFactory
import com.android.epoxytest.api.GithubService
import com.android.epoxytest.data.GithubRepository

object CompositionRoot {

    val githubRepository: GithubRepository
        get() = GithubRepository(service = githubService)

    val githubService: GithubService
        get() = GithubService.create()

    val viewModelFactory = ViewModelFactory(
        repository = githubRepository
    )

}