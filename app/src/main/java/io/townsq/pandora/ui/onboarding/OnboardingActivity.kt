package io.townsq.pandora.ui.onboarding

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.commit
import io.townsq.pandora.R
import io.townsq.pandora.databinding.ActivityOnboardingBinding

class OnboardingActivity : AppCompatActivity() {

    private var binding: ActivityOnboardingBinding? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityOnboardingBinding.inflate(layoutInflater)
        setContentView(binding?.root)

        supportFragmentManager.commit {
            replace(R.id.onboardingFragmentContainer, OnboardingFragment())
        }
    }
}
