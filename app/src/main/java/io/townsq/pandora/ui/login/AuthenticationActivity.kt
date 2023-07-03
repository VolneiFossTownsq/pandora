package io.townsq.pandora.ui.login

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.commit
import io.townsq.pandora.R
import io.townsq.pandora.databinding.ActivityAuthenticationBinding
import io.townsq.pandora.ui.feed.FeedFragment

class AuthenticationActivity : AppCompatActivity() {

    private var binding: ActivityAuthenticationBinding? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAuthenticationBinding.inflate(layoutInflater)
        setContentView(binding?.root)

        supportFragmentManager.commit {
            replace(R.id.authenticationFragmentContainer, LoginFragment())
        }
    }
}
