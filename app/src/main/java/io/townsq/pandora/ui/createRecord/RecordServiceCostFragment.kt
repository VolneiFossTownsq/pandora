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
import io.townsq.pandora.R
import io.townsq.pandora.databinding.FragmentRecordServiceCostBinding
import io.townsq.pandora.ui.feed.FeedActivity

class RecordServiceCostFragment : Fragment() {

    private var binding: FragmentRecordServiceCostBinding? = null
    private var backToAction: ImageView? = null
    private var goToFeed: Button? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentRecordServiceCostBinding.inflate(inflater, container, false)

        backToAction = binding?.backToRecordAction
        goToFeed = binding?.createRecord

        setupViews()

        return binding?.root
    }

    private fun setupViews() {
        backToAction?.setOnClickListener {
            onClickToAction()
        }
        goToFeed?.setOnClickListener {
            onClickGoToFeed()
        }
    }

    private fun onClickToAction() {
        findNavController().navigate(R.id.action_recordServiceCostFragment_to_recordActionFragment)
    }

    private fun onClickGoToFeed() {
        val intent = Intent(requireContext(), FeedActivity::class.java)
        startActivity(intent)
    }
}
