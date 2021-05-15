package com.android.epoxytest.usecase

import androidx.paging.Pager
import com.android.epoxytest.data.GithubRepository
import com.android.epoxytest.data.entity.Repo

class SearchGithubRepositoryPageUseCase constructor(
    private val repository: GithubRepository
) {
    fun execute(query: String): Pager<Int, Repo> {
        return repository.search(query)
    }
}