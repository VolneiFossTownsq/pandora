package io.townsq.pandora.ui.createRecord

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.Toast
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import io.townsq.pandora.R
import io.townsq.pandora.components.CardPandora
import io.townsq.pandora.data.models.RecordType
import io.townsq.pandora.databinding.FragmentRecordActionBinding
import org.koin.androidx.viewmodel.ext.android.activityViewModel

class RecordActionFragment : Fragment() {

    private val recordViewModel: RecordViewModel by activityViewModel()
    private var selectedCustomView: CardPandora? = null
    private var optionMaintenance: CardPandora? = null
    private var optionShift: CardPandora? = null
    private var optionGas: CardPandora? = null
    private var actionCreate: Button? = null
    private var binding: FragmentRecordActionBinding? = null
    private var backToSelectVehicle: ImageView? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentRecordActionBinding.inflate(inflater, container, false)

        optionMaintenance = binding?.optionMaintenance
        optionShift = binding?.optionShift
        optionGas = binding?.optionGas
        actionCreate = binding?.actionContinueToServiceCost
        backToSelectVehicle = binding?.backToSelectVehicle

        setupView()

        return binding?.root
    }

    private fun setupBindings() {
        recordViewModel.postIsSuccess.observe(viewLifecycleOwner) {
            postRecordIsSuccess(it)
        }
    }

    private fun setupView() {
        setupRecordTypeOptions()

        actionCreate?.setOnClickListener {
            onButtonFinalizeRecordCreateClicked()
        }

        backToSelectVehicle?.setOnClickListener {
            backToVehicleSelection()
        }

        optionMaintenance?.setOnClickListener {
            recordViewModel.setSelectedRecordType(RecordType.MAINTENANCE)
            onCustomViewClicked(optionMaintenance)
        }

        optionShift?.setOnClickListener {
            recordViewModel.setSelectedRecordType(RecordType.SHIFT)
            onCustomViewClicked(optionShift)
        }

        optionGas?.setOnClickListener {
            recordViewModel.setSelectedRecordType(RecordType.GAS)
            onCustomViewClicked(optionGas)
        }
    }

    private fun backToVehicleSelection() {
        findNavController().popBackStack()
    }

    private fun onButtonFinalizeRecordCreateClicked() {
        when (recordViewModel.selectedRecordType.value) {
            RecordType.SHIFT -> {
                activity?.finish()
                recordViewModel.postNewRecord()
            }
            null -> {
                Toast.makeText(requireContext(), "choose a card", Toast.LENGTH_SHORT)
                    .show()
            }
            else -> {
                findNavController().navigate(R.id.action_recordActionFragment_to_recordServiceCostFragment)
            }
        }
    }
    private fun postRecordIsSuccess(isSuccess: Boolean) {
        if (isSuccess) {
            Toast.makeText(requireContext(), "Record created successfully!", Toast.LENGTH_SHORT).show()
            activity?.run {
                setResult(Activity.RESULT_OK, Intent())
                finish()
            }
        } else {
            Toast.makeText(
                requireContext(),
                "Failed to create record, please try again later!",
                Toast.LENGTH_LONG
            ).show()
        }
    }

    private fun onCustomViewClicked(customView: CardPandora?) {
        val defaultBgColor = ContextCompat.getColor(requireContext(), R.color.white)
        val defaultIcColor = ContextCompat.getColor(requireContext(), R.color.black)
        val clickedBgColor = ContextCompat.getColor(requireContext(), R.color.red_mask)
        val clickedIcColor = ContextCompat.getColor(requireContext(), R.color.rouge_red)
        selectedCustomView?.let { previousCustomView ->
            previousCustomView.setColors(defaultIcColor, defaultBgColor)
            previousCustomView.setTextColor(defaultIcColor)
        }
        customView?.setColors(clickedIcColor, clickedBgColor)
        customView?.setTextColor(defaultBgColor)
        selectedCustomView = customView
    }

    private fun setupRecordTypeOptions() {
        optionMaintenance?.newInstance(RecordType.MAINTENANCE)
        optionShift?.newInstance(RecordType.SHIFT)
        optionGas?.newInstance(RecordType.GAS)
    }
}
