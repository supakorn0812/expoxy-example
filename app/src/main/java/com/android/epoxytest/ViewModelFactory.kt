package com.android.epoxytest

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.android.epoxytest.usecase.SearchGithubRepositoryPageUseCase

/**
 * Factory for ViewModels
 */
class ViewModelFactory(private val searchGithubRepositoryPageUseCase: SearchGithubRepositoryPageUseCase) :
    ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(SearchRepositoriesViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return SearchRepositoriesViewModel(
                searchGithubRepositoryPageUseCase
            ) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}