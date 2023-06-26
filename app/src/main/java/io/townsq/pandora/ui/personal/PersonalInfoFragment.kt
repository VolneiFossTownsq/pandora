package io.townsq.pandora.ui.personal

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import io.townsq.pandora.R
import io.townsq.pandora.databinding.FragmentPersonalInfoBinding

class PersonalInfoFragment : Fragment() {

    private var binding: FragmentPersonalInfoBinding? = null
    var returnToLogin: ImageView? = null
    var goToRoleSelection: Button? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentPersonalInfoBinding.inflate(inflater, container, false)

        returnToLogin = binding?.backToLogin
        goToRoleSelection = binding?.goToRoleSelection

        setupView()

        return binding?.root
    }

    private fun setupView() {
        returnToLogin?.setOnClickListener {
            Toast.makeText(activity, "Return Login", Toast.LENGTH_SHORT).show()
        }

        goToRoleSelection?.setOnClickListener {
            onClickToRoleSelection()
        }
    }

    private fun onClickToRoleSelection() {
        Log.d("PersonalInfoFragment", "Button clicked")
        findNavController().navigate(R.id.action_personalInfoFragment_to_roleSelectionFragment)
    }
}
