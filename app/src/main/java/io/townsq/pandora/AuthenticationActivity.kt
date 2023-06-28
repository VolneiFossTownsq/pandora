package io.townsq.pandora

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import io.townsq.pandora.R
import io.townsq.pandora.databinding.ActivityAuthenticationBinding

class AuthenticationActivity : AppCompatActivity() {

    private var binding: ActivityAuthenticationBinding? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAuthenticationBinding.inflate(layoutInflater)
        setContentView(binding?.root)
    }
}