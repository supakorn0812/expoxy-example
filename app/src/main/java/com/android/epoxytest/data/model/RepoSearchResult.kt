package com.android.epoxytest.data.model

import com.android.epoxytest.data.entity.Repo

sealed class RepoSearchResult {
    data class Success(val data: List<Repo>) : RepoSearchResult()
    data class Error(val error: Exception) : RepoSearchResult()
}
