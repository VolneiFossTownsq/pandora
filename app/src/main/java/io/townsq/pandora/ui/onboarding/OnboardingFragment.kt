package io.townsq.pandora.ui.onboarding

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import io.townsq.pandora.databinding.FragmentOnboardingBinding
import io.townsq.pandora.ui.login.AuthenticationActivity
import io.townsq.pandora.ui.register.RegisterActivity

class OnboardingFragment : Fragment() {

    private var binding: FragmentOnboardingBinding? = null
    private var register: Button? = null
    private var login: Button? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentOnboardingBinding.inflate(inflater, container, false)

        register = binding?.toCreateAccount
        login = binding?.toLogin

        setupView()

        return binding?.root
    }

    private fun setupView() {
        register?.setOnClickListener {
            val intent = Intent(requireContext(), RegisterActivity::class.java)
            startActivity(intent)
        }

        login?.setOnClickListener {
            val intent = Intent(requireContext(), AuthenticationActivity::class.java)
            startActivity(intent)
        }
    }
}
