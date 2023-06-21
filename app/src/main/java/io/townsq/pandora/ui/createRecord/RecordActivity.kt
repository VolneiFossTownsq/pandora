package io.townsq.pandora.ui.createRecord

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.fragment.NavHostFragment
import io.townsq.pandora.R
import io.townsq.pandora.databinding.ActivityRecordBinding

class RecordActivity : AppCompatActivity() {

    private var binding: ActivityRecordBinding? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRecordBinding.inflate(layoutInflater)
        setContentView(binding?.root)

        val navigationHostFragment =
            supportFragmentManager.findFragmentById(R.id.containerRecord) as NavHostFragment
        val navigationController = navigationHostFragment.navController

        navigationController.setGraph(R.navigation.nav_graph_create_record)
    }
}