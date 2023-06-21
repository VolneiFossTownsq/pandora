package io.townsq.pandora.ui.register.password

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import io.townsq.pandora.R

class PasswordFragment : Fragment() {

    private var backToRoleSelection: ImageView? = null
    private var goToConfirmation: Button? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_password, container, false)

        backToRoleSelection = view.findViewById(R.id.backToRoleSelection)
        goToConfirmation = view.findViewById(R.id.goToConfirmation)

        setupView()

        return view
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