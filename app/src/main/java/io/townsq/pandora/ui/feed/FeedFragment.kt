package io.townsq.pandora.ui.feed

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.appcompat.widget.SearchView
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.chip.Chip
import io.townsq.pandora.R
import io.townsq.pandora.data.models.RecordType
import io.townsq.pandora.databinding.FragmentFeedBinding
import io.townsq.pandora.ui.feed.adapter.RecordAdapter
import io.townsq.pandora.ui.recordDetails.RecordDetailsActivity
import org.koin.androidx.viewmodel.ext.android.activityViewModel

class FeedFragment : Fragment() {

    private var binding: FragmentFeedBinding? = null
    private val feedViewModel: FeedViewModel by activityViewModel()
    private var recyclerView: RecyclerView? = null
    private var recordAdapter: RecordAdapter = RecordAdapter(::navigateToDetails)
    private var searchView: SearchView? = null
    private var maintenanceButton: Chip? = null
    private var shiftButton: Chip? = null
    private var gasButton: Chip? = null
    private var menu: ImageView? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentFeedBinding.inflate(inflater, container, false)

        recyclerView = binding?.recyclerView
        recyclerView?.adapter = recordAdapter

        maintenanceButton = binding?.maintenance
        shiftButton = binding?.shift
        gasButton = binding?.gas
        searchView = binding?.searchView

        menu = binding?.menuFeed

        setupBindings()
        setupViews()

        return binding?.root
    }

    private fun navigateToDetails(recordId: String) {
        val intent = Intent(requireContext(), RecordDetailsActivity::class.java)
        intent.putExtra("recordId", recordId)
        startActivity(intent)
    }

    private fun setupViews() {
        onClickFilter()
        setupSearchView()
        openMenu()
    }

    private fun setupBindings() {
        feedViewModel.filteredRecordsLiveData.observe(viewLifecycleOwner) { filteredRecords ->
            filteredRecords?.let { recordAdapter.setRecords(it) }
        }

        feedViewModel.recordsLiveData.observe(viewLifecycleOwner) { records ->
            recordAdapter.setRecords(records)
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
                feedViewModel.addFilter(RecordType.SHIFT)
            } else {
                feedViewModel.removeFilter(RecordType.SHIFT)
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

    private fun openMenu() {
        menu?.setOnClickListener {
            val drawerLayout: DrawerLayout = requireActivity().findViewById(R.id.drawerLayout)
            drawerLayout.openDrawer(GravityCompat.END)
        }
    }

}
