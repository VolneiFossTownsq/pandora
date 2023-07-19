package io.townsq.pandora.ui.createRecord

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.Toast
import androidx.core.content.ContentProviderCompat.requireContext
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import io.townsq.pandora.R
import io.townsq.pandora.databinding.FragmentRecordServiceCostBinding
import org.koin.androidx.viewmodel.ext.android.activityViewModel

class RecordServiceCostFragment : Fragment() {

    private val recordViewModel: RecordViewModel by activityViewModel()
    private var binding: FragmentRecordServiceCostBinding? = null
    private var backToAction: ImageView? = null
    private var goToFeed: Button? = null
    private var serviceCost: EditText? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentRecordServiceCostBinding.inflate(inflater, container, false)

        backToAction = binding?.backToRecordAction
        goToFeed = binding?.createRecord

        setupBindings()
        setupViews()

        return binding?.root
    }

    private fun setupBindings() {
        recordViewModel.postIsSuccess.observe(viewLifecycleOwner) {
            postRecordIsSuccess(it)
        }
    }

    private fun setupViews() {
        backToAction?.setOnClickListener {
            findNavController().navigate(R.id.action_recordServiceCostFragment_to_recordActionFragment)
        }
        goToFeed?.setOnClickListener {
            Toast.makeText(requireContext(), "Record successfully created!", Toast.LENGTH_SHORT)
                .show()
            finishRecord()
        }
    }

    private fun finishRecord() {
        val serviceCostValue = serviceCost?.text.toString()
        if (serviceCostValue.isNotEmpty()) {
            recordViewModel.postNewRecord(serviceCostValue.toFloat())
        } else {
            Toast.makeText(
                requireContext(),
                "inform the cost of the service!",
                Toast.LENGTH_SHORT
            ).show()
        }
    }

    private fun postRecordIsSuccess(isSuccess: Boolean,) {
        if (isSuccess) {
            Toast.makeText(requireContext(), "Record successfully created!", Toast.LENGTH_SHORT).show()

            activity?.run {
                setResult(Activity.RESULT_OK, Intent())
                finish()
            }
        } else {
            Toast.makeText(
                requireContext(),
                "Registration failed, try again later!",
                Toast.LENGTH_LONG
            ).show()
        }
    }
}
