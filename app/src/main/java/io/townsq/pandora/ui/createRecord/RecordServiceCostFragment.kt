package io.townsq.pandora.ui.createRecord

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import io.townsq.pandora.databinding.FragmentRecordServiceCostBinding

class RecordServiceCostFragment : Fragment() {

    private var binding: FragmentRecordServiceCostBinding? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentRecordServiceCostBinding.inflate(inflater, container, false)

        return binding?.root
    }
}
