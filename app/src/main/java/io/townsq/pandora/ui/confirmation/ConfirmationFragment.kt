package io.townsq.pandora.ui.confirmation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import io.townsq.pandora.R

class ConfirmationFragment : Fragment() {

    private var backToPassword: ImageView? = null
    private var goToLogin: Button? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_confirmation, container, false)

        backToPassword = view.findViewById(R.id.backToPassword)
        goToLogin = view.findViewById(R.id.goToLogin)

        setupView()

        return view
    }

    private fun setupView() {
        backToPassword?.setOnClickListener {
            backToRoleSelection()
        }

        goToLogin?.setOnClickListener {
            login()
        }
    }

    private fun backToRoleSelection() {
        findNavController().navigate(R.id.action_confirmationFragment_to_passwordFragment)
    }

    private fun login() {
        findNavController().navigate(R.id.action_confirmationFragment_to_loginFragment)
    }
}
