package io.townsq.pandora.ui.createRecord

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.fragment.NavHostFragment
import io.townsq.pandora.R
import io.townsq.pandora.databinding.ActivityRecordBinding
import org.koin.androidx.viewmodel.ext.android.viewModel

class RecordActivity : AppCompatActivity() {

    companion object {
        const val ARG_DRIVER_ID = "driverId"
    }

    private val recordViewModel: RecordViewModel by viewModel()
    private var binding: ActivityRecordBinding? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRecordBinding.inflate(layoutInflater)
        setContentView(binding?.root)

        val navigationHostFragment =
            supportFragmentManager.findFragmentById(R.id.containerRecord) as NavHostFragment
        val navigationController = navigationHostFragment.navController

        getVehicles()

        navigationController.setGraph(R.navigation.nav_graph_create_record)
    }

    private fun getVehicles() {
        recordViewModel.getVehiclesByDriverId(intent.extras?.getString(ARG_DRIVER_ID).toString())
    }
}
