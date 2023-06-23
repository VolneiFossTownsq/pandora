package io.townsq.pandora.ui.createRecord

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
import io.townsq.pandora.data.RecordType
import io.townsq.pandora.databinding.FragmentRecordActionBinding

class RecordActionFragment : Fragment() {

    private var selectedCustomView: CardPandora? = null
    private var optionMaintenance: CardPandora? = null
    private var optionShift: CardPandora? = null
    private var optionGas: CardPandora? = null
    private var actionCreate: Button? = null
    private var binding: FragmentRecordActionBinding? = null
    private var continueToFeed: Button? = null
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
        actionCreate = binding?.actionCreate
        continueToFeed = binding?.actionCreate
        backToSelectVehicle = binding?.backToSelectVehicle

        setupView()

        return binding?.root
    }

    private fun setupView() {
        setupInstances()

        continueToFeed?.setOnClickListener {
            onClickToFeed()
        }

        backToSelectVehicle?.setOnClickListener {
            backToSelectVehicle()
        }

        optionMaintenance?.setOnClickListener {
            onCustomViewClicked(optionMaintenance)
        }

        optionShift?.setOnClickListener {
            onCustomViewClicked(optionShift)
        }

        optionGas?.setOnClickListener {
            onCustomViewClicked(optionGas)
        }
    }

    private fun onClickToFeed() {
        Toast.makeText(requireContext(), "Go to Feed", Toast.LENGTH_SHORT).show()
    }

    private fun backToSelectVehicle() {
        findNavController().navigate(R.id.action_recordActionFragment_to_vehicleSelectionFragment)
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

    private fun setupInstances() {
        optionMaintenance?.newInstance(RecordType.MAINTENANCE)
        optionShift?.newInstance(RecordType.SHIFT_START)
        optionGas?.newInstance(RecordType.GAS)
    }
}
