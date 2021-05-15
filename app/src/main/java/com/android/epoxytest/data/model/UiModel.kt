package com.android.epoxytest.data.model

import com.android.epoxytest.data.entity.Repo

sealed class UiModel {
    data class RepoItem(val repo: Repo) : UiModel()
    data class SeparatorItem(val description: String) : UiModel()
}
