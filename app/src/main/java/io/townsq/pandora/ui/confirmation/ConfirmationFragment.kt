package io.townsq.pandora.ui.confirmation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import io.townsq.pandora.R
import io.townsq.pandora.databinding.FragmentConfirmationBinding

class ConfirmationFragment : Fragment() {

    private var binding: FragmentConfirmationBinding? = null
    private var backToPassword: ImageView? = null
    private var goToLogin: Button? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentConfirmationBinding.inflate(inflater, container, false)

        backToPassword = binding?.backToPassword
        goToLogin = binding?.goToLogin

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
        Toast.makeText(activity, "Login", Toast.LENGTH_SHORT).show()
    }
}