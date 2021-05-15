package com.android.epoxytest

import android.os.Bundle
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.airbnb.epoxy.EpoxyAttribute
import com.airbnb.epoxy.EpoxyRecyclerView
import com.android.epoxytest.adapter.StoreLocationController

class MainActivity : AppCompatActivity() {

    lateinit var editTextSearch: EditText
    lateinit var recyclerView: EpoxyRecyclerView

    private val mController by lazy {
        StoreLocationController()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        editTextSearch = findViewById(R.id.edit_text_search)
        recyclerView = findViewById(R.id.recycler_view)
        init(savedInstanceState)
    }

    private fun init(savedInstanceState: Bundle?) {
        recyclerView.apply {
            setController(mController)
            layoutManager = LinearLayoutManager(this@MainActivity, RecyclerView.VERTICAL, false)
        }
        mController.setData(Unit)
    }
}