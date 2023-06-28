package io.townsq.pandora.ui.recordDetails

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import io.townsq.pandora.databinding.FragmentRecordDetailsBinding

class RecordDetailsFragment : Fragment() {

    private var binding: FragmentRecordDetailsBinding? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentRecordDetailsBinding.inflate(inflater, container, false)

        return binding?.root
    }
}
