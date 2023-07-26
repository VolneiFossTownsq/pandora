package io.townsq.pandora.ui.register.personal

import android.content.Intent
import android.os.Bundle
import android.util.Log
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
import io.townsq.pandora.databinding.FragmentPersonalInfoBinding
import io.townsq.pandora.ui.login.AuthenticationActivity

class PersonalInfoFragment : Fragment() {

    private var binding: FragmentPersonalInfoBinding? = null
    private var firstName: EditText? = null
    private var lastName: EditText? = null
    private var returnToLogin: ImageView? = null
    private var goToRoleSelection: Button? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentPersonalInfoBinding.inflate(inflater, container, false)

        firstName = binding?.firstName
        lastName = binding?.lastName
        returnToLogin = binding?.backToLogin
        goToRoleSelection = binding?.goToRoleSelection

        setupView()

        return binding?.root
    }

    private fun setupView() {
        returnToLogin?.setOnClickListener {
            returnLogin()
        }

        goToRoleSelection?.setOnClickListener {
            onClickToPassword()
        }
    }

    private fun onClickToPassword() {
        val bundle = Bundle()
        bundle.putString("firstName", firstName?.text.toString())
        bundle.putString("lastName", lastName?.text.toString())
        findNavController().navigate(R.id.action_personalInfoFragment_to_passwordFragment, bundle)
    }

    private fun returnLogin(){
        val intent = Intent(activity, AuthenticationActivity::class.java)
        startActivity(intent)
        requireActivity().finish()
    }
}
