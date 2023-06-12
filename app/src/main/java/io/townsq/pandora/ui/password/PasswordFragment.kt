package io.townsq.pandora.ui.password

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import io.townsq.pandora.R
import io.townsq.pandora.databinding.FragmentPasswordBinding

class PasswordFragment : Fragment() {

    private var binding: FragmentPasswordBinding? = null
    private var backToRoleSelection: ImageView? = null
    private var goToConfirmation: Button? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentPasswordBinding.inflate(inflater, container, false)

        backToRoleSelection = binding?.backToRoleSelection
        goToConfirmation = binding?.goToConfirmation

        setupView()

        return binding?.root
    }

    private fun setupView() {

        backToRoleSelection?.setOnClickListener {
            backToRoleSelection()
        }

        goToConfirmation?.setOnClickListener {
            onClickToConfirmation()
        }
    }

    private fun backToRoleSelection() {
        findNavController().navigate(R.id.action_passwordFragment_to_roleSelectionFragment)
    }

    private fun onClickToConfirmation() {
        findNavController().navigate(R.id.action_passwordFragment_to_confirmationFragment)
    }
}