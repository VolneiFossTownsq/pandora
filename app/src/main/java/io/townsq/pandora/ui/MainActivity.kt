package io.townsq.pandora.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import io.townsq.pandora.R
import io.townsq.pandora.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private var binding : ActivityMainBinding? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding?.root)
    }
}