package com.android.epoxytest

import android.os.Bundle
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.widget.addTextChangedListener
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import androidx.paging.LoadState
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.airbnb.epoxy.EpoxyRecyclerView
import com.android.epoxytest.adapter.RepositoryController
import com.android.epoxytest.di.CompositionRoot
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.FlowPreview
import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

@FlowPreview
@ExperimentalCoroutinesApi
class MainActivity : AppCompatActivity() {

    lateinit var editTextSearch: EditText
    lateinit var recyclerView: EpoxyRecyclerView

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
            layoutManager = LinearLayoutManager(this@MainActivity, RecyclerView.VERTICAL, false)
        }

        mController.addLoadStateListener { loadState ->
            // show empty list
            val errorState = loadState.source.append as? LoadState.Error
                ?: loadState.source.prepend as? LoadState.Error
                ?: loadState.append as? LoadState.Error
                ?: loadState.prepend as? LoadState.Error

            errorState?.let {
                Toast.makeText(
                    this,
                    "\uD83D\uDE28 Wooops ${it.error}",
                    Toast.LENGTH_LONG
                ).show()
                mController.retry()
            }
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