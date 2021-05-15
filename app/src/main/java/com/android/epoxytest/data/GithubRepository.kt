package com.android.epoxytest.data

import androidx.paging.Pager
import androidx.paging.PagingConfig
import com.android.epoxytest.api.GithubService
import com.android.epoxytest.data.entity.Repo

/**
 * Repository class that works with local and remote data sources.
 */
class GithubRepository(private val service: GithubService) {

    /**
     * Search repositories whose names match the query, exposed as a stream of data that will emit
     * every time we get more data from the network.
     */
    fun search(query: String): Pager<Int, Repo> {
        val pager =  Pager(
            config = PagingConfig(
                pageSize = NETWORK_PAGE_SIZE,
                enablePlaceholders = false
            ),
            pagingSourceFactory = {
                GithubPagingSource(service, query)
            }
        )
        return pager
    }

    companion object {
        const val NETWORK_PAGE_SIZE = 15
    }
}