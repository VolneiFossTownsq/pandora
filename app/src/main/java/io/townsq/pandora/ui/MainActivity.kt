package io.townsq.pandora.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import io.townsq.pandora.R
import io.townsq.pandora.databinding.ActivityMainBinding
import io.townsq.pandora.databinding.ActivityRegisterBinding

class MainActivity : AppCompatActivity() {

    private var binding: ActivityMainBinding? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding?.root)
    }
}