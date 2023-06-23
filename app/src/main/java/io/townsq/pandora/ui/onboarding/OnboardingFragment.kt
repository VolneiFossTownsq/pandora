package io.townsq.pandora.ui.onboarding

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import io.townsq.pandora.databinding.FragmentOnboardingBinding


class OnboardingFragment : Fragment() {

    private var binding: FragmentOnboardingBinding? = null
    private var register: Button? = null
    private var login: Button? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentOnboardingBinding.inflate(inflater, container, false)

        register = binding?.toCreateAccount
        login = binding?.toLogin

        setupView()

        return binding?.root
    }

    private fun setupView(){
        register?.setOnClickListener {

        }
        login?.setOnClickListener {

        }
    }

}