package io.townsq.pandora.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.NavHostFragment
import io.townsq.pandora.R
import io.townsq.pandora.databinding.ActivityRegisterBinding

class RegisterActivity : AppCompatActivity() {

    private var binding: ActivityRegisterBinding? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRegisterBinding.inflate(layoutInflater)
        setContentView(binding?.root)

        val navigationHostFragment =
            supportFragmentManager.findFragmentById(R.id.fragment_container) as NavHostFragment
        val navigationController = navigationHostFragment.navController

        navigationController.setGraph(R.navigation.nav_graph)
    }
}