package io.townsq.pandora.ui.login

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import io.townsq.pandora.databinding.FragmentLoginBinding
import io.townsq.pandora.ui.feed.FeedActivity

class LoginFragment : Fragment() {

    private var binding: FragmentLoginBinding? = null
    private var navigateToFeed: Button? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentLoginBinding.inflate(inflater, container, false)
        navigateToFeed = binding?.login
        setupViews()

        return binding?.root
    }

    private fun setupViews() {
        navigateToFeed()
    }

    private fun navigateToFeed() {
        navigateToFeed?.setOnClickListener {
            val intent = Intent(requireContext(), FeedActivity::class.java)
            startActivity(intent)
        }
    }
}
