package io.townsq.pandora.ui.recordDetails

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import io.townsq.pandora.data.models.Record
import io.townsq.pandora.databinding.FragmentRecordDetailsBinding
import io.townsq.pandora.utils.DateFormat
import org.koin.androidx.viewmodel.ext.android.activityViewModel

class RecordDetailsFragment : Fragment() {

    private var binding: FragmentRecordDetailsBinding? = null
    private val recordDetailsViewModel: RecordDetailsViewModel by activityViewModel()
    private var infoRecordType: TextView? = null
    private var infoVehicleName: TextView? = null
    private var infoDateDetails: TextView? = null
    private var infoLicensePlateDetails: TextView? = null
    private var infoServiceCost: TextView? = null
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentRecordDetailsBinding.inflate(inflater, container, false)

        infoRecordType = binding?.recordType
        infoVehicleName = binding?.carName
        infoDateDetails = binding?.infoDate
        infoLicensePlateDetails = binding?.plateNumber
        infoServiceCost = binding?.serviceValue

        setupBindings()
        return binding?.root
    }

    private fun setupBindings() {
        recordDetailsViewModel.record.observe(viewLifecycleOwner) { record ->
            onRecordDataFetched(record)
        }
    }

    private fun onRecordDataFetched(record: Record?) {
        infoRecordType?.text = record?.recordType?.type
        infoVehicleName?.text = record?.vehicle?.name
        infoDateDetails?.text = DateFormat().formatDate(record?.recordDate ?: "")
        infoLicensePlateDetails?.text = record?.vehicle?.licensePlate
        infoServiceCost?.text = "$${record?.serviceCost ?: "0"}"
    }
}
