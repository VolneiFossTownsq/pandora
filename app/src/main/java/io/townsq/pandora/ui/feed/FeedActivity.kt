package io.townsq.pandora.ui.feed

import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.SearchView
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.RecyclerView
import io.townsq.pandora.adapter.RecordAdapter
import io.townsq.pandora.data.RecordType
import io.townsq.pandora.databinding.ActivityFeedBinding

class FeedActivity : AppCompatActivity() {

    private var binding: ActivityFeedBinding? = null
    private var recyclerView: RecyclerView? = null
    private var feedViewModel: FeedViewModel? = null
    private var recordAdapter: RecordAdapter? = null
    private var searchView: SearchView? = null
    private var maintenanceButton: Button? = null
    private var shiftButton: Button? = null
    private var gasButton: Button? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFeedBinding.inflate(layoutInflater)
        setContentView(binding?.root)

        recyclerView = binding?.recyclerView
        recordAdapter = RecordAdapter()
        recyclerView?.adapter = recordAdapter

        searchView = binding?.searchView

        maintenanceButton = binding?.maintenance
        shiftButton = binding?.shift
        gasButton = binding?.gas

        feedViewModel = ViewModelProvider(this)[FeedViewModel::class.java]

        feedViewModel?.recordsLiveData?.observe(this) { records ->
            recordAdapter?.setRecords(records)
        }.also {
            feedViewModel?.filteredRecords?.observe(this) { filteredList ->
                if (filteredList != null) {
                    recordAdapter?.setRecords(filteredList)
                }
            }
        }

        onClickFilter()
        setupSearchView()
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

    private fun setupSearchView() {
        searchView?.setOnQueryTextListener(
            object : SearchView.OnQueryTextListener {
                override fun onQueryTextSubmit(query: String?): Boolean {
                    return false
                }

                override fun onQueryTextChange(newText: String?): Boolean {
                    newText?.let {
                        feedViewModel?.filterRecord(it)
                    }
                    return true
                }
            }
        )
    }
}
