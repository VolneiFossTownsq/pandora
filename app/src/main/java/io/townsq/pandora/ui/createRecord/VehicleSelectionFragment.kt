package io.townsq.pandora.ui.createRecord

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.RecyclerView
import io.townsq.pandora.R
import io.townsq.pandora.adapter.CreateRecordAdapter
import io.townsq.pandora.data.models.Vehicle
import io.townsq.pandora.databinding.FragmentVehicleSelectionBinding
import org.koin.androidx.viewmodel.ext.android.activityViewModel

class VehicleSelectionFragment() : Fragment() {

    private var binding: FragmentVehicleSelectionBinding? = null
    private var continueToRecordType: Button? = null
    private var backToFeed: ImageView? = null
    private val recordViewModel: RecordViewModel by activityViewModel()
    private var recyclerViewRecord: RecyclerView? = null
    private var createRecordAdapter: CreateRecordAdapter = CreateRecordAdapter { vehicle ->
        recordViewModel.setSelectedVehicle(vehicle)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentVehicleSelectionBinding.inflate(inflater, container, false)

        continueToRecordType = binding?.continueButtoToRecordType
        backToFeed = binding?.backToFeed
        recyclerViewRecord = binding?.recyclerViewRecordVehicle
        recyclerViewRecord?.adapter = createRecordAdapter

        setupBindings()
        setupViews()

        return binding?.root
    }

    private fun setupViews() {
        continueToRecordType?.setOnClickListener {
            onGoToRecordType()
        }
        backToFeed?.setOnClickListener {
            activity?.finish()
        }
    }

    private fun setupBindings() {
        recordViewModel.vehicleList.observe(viewLifecycleOwner) { vehicleList ->
            setupAdapter(vehicleList)
        }
    }

    private fun setupAdapter(vehicleList: List<Vehicle>) {
        with(recyclerViewRecord) {
            this?.setHasFixedSize(true)
            this?.adapter = createRecordAdapter
        }
        createRecordAdapter.setVehicleList(vehicleList)
    }

    private fun onGoToRecordType() {
        if (recordViewModel.selectedVehicle.value == null) {
            Toast.makeText(requireContext(), "Escolha uma opção para continuar", Toast.LENGTH_SHORT)
                .show()
        } else {
            findNavController().navigate(R.id.action_vehicleSelectionFragment_to_recordActionFragment)
        }
    }
}
