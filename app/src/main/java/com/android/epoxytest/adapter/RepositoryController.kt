package com.android.epoxytest.adapter

import android.util.Log
import com.airbnb.epoxy.EpoxyModel
import com.airbnb.epoxy.paging3.PagingDataEpoxyController
import com.airbnb.epoxy.stickyheader.StickyHeaderCallbacks
import com.android.epoxytest.RepoViewBindingModel_
import com.android.epoxytest.RepoViewSkeletonBindingModel_
import com.android.epoxytest.SeparatorViewBindingModel_
import com.android.epoxytest.data.model.UiModel
import kotlinx.coroutines.ObsoleteCoroutinesApi

@ObsoleteCoroutinesApi
class RepositoryController : PagingDataEpoxyController<UiModel>(), StickyHeaderCallbacks {

    override fun buildItemModel(currentPosition: Int, item: UiModel?): EpoxyModel<*> {
        Log.d("paging_current", "$currentPosition")
        val model = when {
            item is UiModel.RepoItem -> {
                RepoViewBindingModel_()
                    .id("repo_view_$currentPosition")
                    .repo(item.repo)
            }
            item is UiModel.SeparatorItem -> {
                SeparatorViewBindingModel_()
                    .id("skeleton_$currentPosition")
                    .item(item)
            }
            else -> {
                RepoViewSkeletonBindingModel_()
                    .id("repo_view_skeleton_$currentPosition")
            }
        }
        return model
    }

    override fun isStickyHeader(position: Int): Boolean {
        return adapter.getModelAtPosition(position) is SeparatorViewBindingModel_
    }
}