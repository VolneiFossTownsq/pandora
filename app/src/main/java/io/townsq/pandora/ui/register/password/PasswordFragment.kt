package io.townsq.pandora.ui.register.password

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import io.townsq.pandora.R
import io.townsq.pandora.data.models.Register
import io.townsq.pandora.databinding.FragmentPasswordBinding
import io.townsq.pandora.ui.register.RegisterViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class PasswordFragment : Fragment() {

    private val registerViewModel: RegisterViewModel by viewModel()
    private var binding: FragmentPasswordBinding? = null
    private var document: EditText? = null
    private var password: EditText? = null
    private var backToRoleSelection: ImageView? = null
    private var goToConfirmation: Button? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentPasswordBinding.inflate(inflater, container, false)

        document = binding?.document
        password = binding?.password
        backToRoleSelection = binding?.backToRoleSelection
        goToConfirmation = binding?.goToConfirmation

        setupView()
        setupBinding()

        return binding?.root
    }

    private fun setupView() {
        backToRoleSelection?.setOnClickListener {
            backToPersonalInfo()
        }

        goToConfirmation?.setOnClickListener {
            finishRegister()
        }
    }

    private fun setupBinding() {
        registerViewModel.registerResponse.observe(viewLifecycleOwner) { register ->
            if (register != null) {
                onClickToConfirmation()
            } else {
                Toast.makeText(requireContext(), "Falha no registro", Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun finishRegister() {
        val firstName = arguments?.getString("firstName").toString()
        val lastName = arguments?.getString("lastName").toString()

        registerViewModel.postRegister(
            Register(
                firstName = firstName,
                lastName = lastName,
                document = document?.text.toString(),
                password = password?.text.toString()
            )
        )
    }

    private fun backToPersonalInfo() {
        findNavController().navigate(R.id.action_passwordFragment_to_personalInfoFragment)
    }

    private fun onClickToConfirmation() {
        findNavController().navigate(R.id.action_passwordFragment_to_confirmationFragment)
    }

}
