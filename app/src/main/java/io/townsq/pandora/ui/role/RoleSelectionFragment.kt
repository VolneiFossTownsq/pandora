package io.townsq.pandora.ui.role

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.AutoCompleteTextView
import android.widget.Button
import android.widget.ImageView
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import io.townsq.pandora.R
import io.townsq.pandora.databinding.FragmentRoleSelectionBinding

class RoleSelectionFragment : Fragment() {

    private var binding: FragmentRoleSelectionBinding? = null
    var textField: AutoCompleteTextView? = null
    var returnToPersonalInfo: ImageView? = null
    var goToPassword: Button? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentRoleSelectionBinding.inflate(inflater, container, false)

        returnToPersonalInfo = binding?.backToPersonalInfo
        goToPassword = binding?.goToPassword

        setupView()

        return binding?.root
    }

    private fun setupView() {

        returnToPersonalInfo?.setOnClickListener {
            backToPersonalInfo()
        }

        goToPassword?.setOnClickListener {
            goToPassword()
        }

        textField = binding?.autoCompleteTextView
        setItensDropMenu()
    }

    private fun setItensDropMenu() {
        val items = listOf("Admin", "Manager", "Employee")
        val adapter = ArrayAdapter(requireContext(), R.layout.list_item, R.id.itemTextView, items)
        textField?.setAdapter(adapter)
    }

    private fun backToPersonalInfo() {
        findNavController().navigate(R.id.action_roleSelectionFragment_to_personalInfoFragment)
    }

    private fun goToPassword() {
        findNavController().navigate(R.id.action_roleSelectionFragment_to_passwordFragment)
    }
}