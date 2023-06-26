package io.townsq.pandora.ui.feed

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.SearchView
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.chip.Chip
import io.townsq.pandora.adapter.RecordAdapter
import io.townsq.pandora.data.RecordType
import io.townsq.pandora.databinding.FragmentFeedBinding
import org.koin.androidx.viewmodel.ext.android.viewModel

class FeedFragment : Fragment() {

    private var binding: FragmentFeedBinding? = null
    private val feedViewModel: FeedViewModel by viewModel()
    private var recyclerView: RecyclerView? = null
    private var recordAdapter: RecordAdapter? = null
    private var searchView: SearchView? = null
    private var maintenanceButton: Chip? = null
    private var shiftButton: Chip? = null
    private var gasButton: Chip? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentFeedBinding.inflate(inflater, container, false)

        recordAdapter = RecordAdapter()
        recyclerView = binding?.recyclerView
        recyclerView?.adapter = recordAdapter

        maintenanceButton = binding?.maintenance
        shiftButton = binding?.shift
        gasButton = binding?.gas
        searchView = binding?.searchView

        setupBindings()
        onClickFilter()
        setupSearchView()

        return binding?.root
    }

    private fun setupBindings() {
        feedViewModel.filteredRecordsLiveData.observe(viewLifecycleOwner) { filteredRecords ->
            filteredRecords?.let { recordAdapter?.setRecords(it) }
        }

        feedViewModel.recordsLiveData.observe(viewLifecycleOwner) { records ->
            recordAdapter?.setRecords(records)
        }
    }

    private fun onClickFilter() {
        maintenanceButton?.setOnCheckedChangeListener { chip, isChecked ->
            if (isChecked) {
                feedViewModel.addFilter(RecordType.MAINTENANCE)
            } else {
                feedViewModel.removeFilter(RecordType.MAINTENANCE)
            }
        }

        shiftButton?.setOnCheckedChangeListener { chip, isChecked ->
            if (isChecked) {
                feedViewModel.addFilter(RecordType.SHIFT_START)
            } else {
                feedViewModel.removeFilter(RecordType.SHIFT_START)
            }
        }

        gasButton?.setOnCheckedChangeListener { chip, isChecked ->
            if (isChecked) {
                feedViewModel.addFilter(RecordType.GAS)
            } else {
                feedViewModel.removeFilter(RecordType.GAS)
            }
        }
    }

    private fun setupSearchView() {
        searchView?.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                return false
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                newText?.let {
                    feedViewModel.filterRecord(it)
                }
                return true
            }
        })
    }
}
