package io.townsq.pandora.ui.login

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.fragment.app.Fragment
import io.townsq.pandora.data.models.Driver
import io.townsq.pandora.data.models.Login
import io.townsq.pandora.databinding.FragmentLoginBinding
import io.townsq.pandora.ui.feed.FeedActivity
import org.koin.androidx.viewmodel.ext.android.viewModel

class LoginFragment : Fragment() {
    private val authenticationViewModel: AuthenticationViewModel by viewModel()
    private var binding: FragmentLoginBinding? = null
    private var navigateToFeed: Button? = null
    private var userName: EditText? = null
    private var password: EditText? = null
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentLoginBinding.inflate(inflater, container, false)
        userName = binding?.userName
        password = binding?.password
        navigateToFeed = binding?.login
        setupViews()
        setupBindings()
        return binding?.root
    }
    private fun setupViews() {
        navigateToFeed?.setOnClickListener {
            val username = userName?.text.toString()
            val password = password?.text.toString()
            if (username == "" || password == "") {
                Toast.makeText(requireContext(), "Preencha todos os campos", Toast.LENGTH_SHORT).show()
            } else {
                val login = Login(username, password)
                authenticationViewModel.sendLogin(login)
            }
        }
    }
    private fun setupBindings() {
        authenticationViewModel.user.observe(viewLifecycleOwner) { user ->
            navigateToFeed(user)
        }
        authenticationViewModel.loading.observe(viewLifecycleOwner) { loading ->
            navigateToFeed?.isEnabled = !loading
        }
    }
    private fun navigateToFeed(user: Driver?) {
        user?.let { driver ->
            val username = userName?.text.toString()
            if (driver.document.toString() == username) {
                val intent = Intent(requireContext(), FeedActivity::class.java)
                intent.putExtra("driverId", driver.id)
                startActivity(intent)
                requireActivity().finish()
            }
        }
    }
}
