package com.android.epoxytest

import android.os.Bundle
import android.util.Log
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.widget.addTextChangedListener
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import androidx.paging.CombinedLoadStates
import androidx.paging.LoadState
import androidx.recyclerview.widget.RecyclerView
import com.airbnb.epoxy.*
import com.airbnb.epoxy.stickyheader.StickyHeaderLinearLayoutManager
import com.android.epoxytest.adapter.RepositoryController
import com.android.epoxytest.di.CompositionRoot
import kotlinx.coroutines.*
import kotlinx.coroutines.channels.BroadcastChannel
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.asFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.flow.debounce

@ObsoleteCoroutinesApi
@FlowPreview
@ExperimentalCoroutinesApi
class MainActivity : AppCompatActivity() {

    lateinit var editTextSearch: EditText
    lateinit var recyclerView: EpoxyRecyclerView


    private val channel by lazy {
        BroadcastChannel<Unit>(Channel.CONFLATED)
    }

    private val flow by lazy {
        channel.asFlow()
            .debounce(2000)
    }

    private val viewModel by lazy {
        ViewModelProvider(this, CompositionRoot.viewModelFactory)
            .get(SearchRepositoriesViewModel::class.java)
    }

    private val mController by lazy {
        RepositoryController()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        editTextSearch = findViewById(R.id.edit_text_search)
        recyclerView = findViewById(R.id.recycler_view)
        init(savedInstanceState)
        initViewModel()
    }

    private fun init(savedInstanceState: Bundle?) {
        editTextSearch.addTextChangedListener {
            lifecycleScope.launch {
                viewModel.queryChannel.send(it.toString())
            }
        }
        recyclerView.apply {
            setController(mController)
            layoutManager =
                StickyHeaderLinearLayoutManager(this@MainActivity, RecyclerView.VERTICAL, false)
        }

        mController.addLoadStateListener { loadState ->
            // show empty list

            Log.d("loadState_", "\n${displayLoadState(loadState)}\n")

            lifecycleScope.launch {
                val errorState = loadState.source.append as? LoadState.Error
                    ?: loadState.source.prepend as? LoadState.Error
                    ?: loadState.append as? LoadState.Error
                    ?: loadState.prepend as? LoadState.Error

                if (errorState != null) {
                    Toast.makeText(
                        this@MainActivity,
                        "\uD83D\uDE28 Wooops ${errorState?.error}",
                        Toast.LENGTH_LONG
                    ).show()
                    channel.send(Unit)
                }
            }

        }

        lifecycleScope.launch {
            flow.collectLatest {
                mController.retry()
            }
        }
    }

    private fun displayLoadState(loadState: CombinedLoadStates): String {
        return listOf(
            "loadState.prepend" to "${loadState.prepend}",
            "loadState.append" to "${loadState.append}",
            "loadState.source" to "${loadState.source}",
            "loadState.refresh" to "${loadState.refresh}",
            "loadState.mediator" to "${loadState.mediator}"

        ).joinToString("\n","\n","\n") { (label, state) ->
            "($label\t,\t$state)"
        }
    }

    private var searchJob: Job? = null

    fun initViewModel() {
        viewModel.query.observe(this) {
            searchJob?.cancel()
            searchJob = lifecycleScope.launch {
                viewModel.search(it).collectLatest {
                    mController.submitData(it)
                }
            }
        }
    }
}
