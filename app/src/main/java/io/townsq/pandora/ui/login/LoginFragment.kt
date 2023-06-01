package io.townsq.pandora.ui.login

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import io.townsq.pandora.R


class LoginFragment : Fragment() {

    private var login: Button? = null
    private var createAccount: TextView? = null
    private var forgotPassword: TextView? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_login, container, false)
        createAccount = view?.findViewById(R.id.createAccount)
        createAccount?.setOnClickListener {
            onClickToFragmentThree()
        }

        forgotPassword = view?.findViewById(R.id.recoveryPassword)
        forgotPassword?.setOnClickListener {
            showToast("Forgot Password clicked")
        }

        login = view?.findViewById(R.id.login)
        login?.setOnClickListener {
            showToast("Login clicked")
        }

        return view
    }

    fun onClickToFragmentThree() {
        findNavController().navigate(R.id.action_loginFragment_to_personalInfoFragment)
    }

    private fun showToast(message: String) {
        Toast.makeText(requireContext(), message, Toast.LENGTH_SHORT).show()
    }
}
