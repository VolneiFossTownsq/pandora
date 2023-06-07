package io.townsq.pandora.ui.feed

import android.os.Bundle
import android.widget.Button
import androidx.appcompat.widget.SearchView
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.RecyclerView
import io.townsq.pandora.R
import io.townsq.pandora.adapter.RecordAdapter
import io.townsq.pandora.data.RecordType

class FeedActivity : AppCompatActivity() {

    private var recyclerView: RecyclerView? = null
    private var feedViewModel: FeedViewModel? = null
    private var recordAdapter: RecordAdapter? = null
    private var searchView: SearchView? = null
    private var maintenanceButton: Button? = null
    private var shiftButton: Button? = null
    private var gasButton: Button? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_feed)

        recyclerView = findViewById(R.id.recyclerView)
        recordAdapter = RecordAdapter()
        recyclerView?.adapter = recordAdapter

        searchView = findViewById(R.id.searchView)

        maintenanceButton = findViewById(R.id.maintenance)
        shiftButton = findViewById(R.id.shift)
        gasButton = findViewById(R.id.gas)

        feedViewModel = ViewModelProvider(this)[FeedViewModel::class.java]

        feedViewModel?.recordsLiveData?.observe(this, Observer { records ->
            recordAdapter?.setRecords(records)
        })

        onClickFilter()
    }

    private fun onClickFilter() {
        maintenanceButton?.setOnClickListener {
            recordAdapter?.filterByRecordType(RecordType.MAINTENANCE)
        }

        shiftButton?.setOnClickListener {
            recordAdapter?.filterByRecordType(RecordType.SHIFT_START)
        }

        gasButton?.setOnClickListener {
            recordAdapter?.filterByRecordType(RecordType.GAS)

        }
    }
}
