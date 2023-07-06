package io.townsq.pandora.ui.createRecord

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.RecyclerView
import io.townsq.pandora.R
import io.townsq.pandora.adapter.CreateRecordAdapter
import io.townsq.pandora.databinding.FragmentVehicleSelectionBinding
import io.townsq.pandora.ui.feed.FeedActivity
import org.koin.androidx.viewmodel.ext.android.viewModel

class VehicleSelectionFragment : Fragment() {

    private var binding: FragmentVehicleSelectionBinding? = null
    private var continueToRecordType: Button? = null
    private var backToFeed: ImageView? = null
    private val recordViewModel: RecordViewModel by viewModel()
    private var recyclerViewRecord: RecyclerView? = null
    private var createRecordAdapter: CreateRecordAdapter? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentVehicleSelectionBinding.inflate(inflater, container, false)

        continueToRecordType = binding?.continueButtoToRecordType
        backToFeed = binding?.backToFeed
        createRecordAdapter = CreateRecordAdapter()
        recyclerViewRecord = binding?.recyclerViewRecordVehicle
        recyclerViewRecord?.adapter = createRecordAdapter

        setupBindings()
        setupView()

        return binding?.root
    }

    fun setupBindings() {
        recordViewModel.recordsLiveData.observe(viewLifecycleOwner) { records ->
            createRecordAdapter?.setRecords(records)
        }

        recordViewModel.selectedItemPosition.observe(viewLifecycleOwner) { selectedPosition ->
            createRecordAdapter?.notifyDataSetChanged()
        }
    }

    private fun setupView() {
        continueToRecordType?.setOnClickListener {
            onClickToRecordType()
        }
        backToFeed?.setOnClickListener {
            onClickBackToFeed()
        }
    }

    private fun onClickToRecordType() {
        findNavController().navigate(R.id.action_vehicleSelectionFragment_to_recordActionFragment)
    }

    private fun onClickBackToFeed(){
        val intent = Intent(requireContext(), FeedActivity::class.java)
        startActivity(intent)
    }
}
