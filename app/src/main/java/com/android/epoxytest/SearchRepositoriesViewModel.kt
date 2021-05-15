package com.android.epoxytest

import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import androidx.paging.PagingData
import androidx.paging.cachedIn
import androidx.paging.insertSeparators
import androidx.paging.map
import com.android.epoxytest.data.model.UiModel
import com.android.epoxytest.usecase.SearchGithubRepositoryPageUseCase
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.FlowPreview
import kotlinx.coroutines.channels.BroadcastChannel
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.asFlow
import kotlinx.coroutines.flow.debounce
import kotlinx.coroutines.flow.map


@FlowPreview
@ExperimentalCoroutinesApi
class SearchRepositoriesViewModel constructor(
    private val searchGithubRepositoryPageUseCase: SearchGithubRepositoryPageUseCase,
) : ViewModel() {

    val queryChannel = BroadcastChannel<String>(Channel.CONFLATED)
    val query = queryChannel.asFlow()
        .debounce(SEARCH_DELAY_MS)
        .asLiveData()

    fun search(query: String): Flow<PagingData<UiModel>> {
        return searchGithubRepositoryPageUseCase.execute(query).flow
            .map {  pagingData -> pagingData.map(UiModel::RepoItem) }
            .map {
                it.insertSeparators<UiModel.RepoItem, UiModel> { before, after ->
                    when {
                        // at the end of the list.
                        after == null -> null
                        // we're at the beginning of the list
                        before == null -> UiModel.SeparatorItem("${after.roundedStarCount}0.000+ stars")
                        before.roundedStarCount > after.roundedStarCount -> {
                            UiModel.SeparatorItem(
                                description = when {
                                    after.roundedStarCount > 1 -> "${after.roundedStarCount}0.000+ stars"
                                    else -> "< 10.000 stars"
                                }
                            )
                        }
                        else -> null
                    }
                }
            }
            .cachedIn(viewModelScope)
    }

    private val UiModel.RepoItem.roundedStarCount: Int
        get() = (this.repo.stars ?: 0) / 10_000

    companion object {
        const val SEARCH_DELAY_MS = 1_000L
    }
}