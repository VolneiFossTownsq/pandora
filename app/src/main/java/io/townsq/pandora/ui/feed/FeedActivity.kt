package io.townsq.pandora.ui.feed

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.commit
import com.google.android.material.floatingactionbutton.FloatingActionButton
import io.townsq.pandora.R
import io.townsq.pandora.databinding.ActivityFeedBinding
import io.townsq.pandora.ui.createRecord.RecordActivity
import org.koin.androidx.viewmodel.ext.android.viewModel
import org.koin.core.parameter.parametersOf

class FeedActivity : AppCompatActivity() {

    companion object {
        const val ARG_DRIVER_ID = "driverId"
    }
    private var binding: ActivityFeedBinding? = null
    private val feedViewModel: FeedViewModel by viewModel {
        parametersOf(
            intent.extras?.getString(ARG_DRIVER_ID)
        )
    }
    private val startActivityCallBack =
        registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->
            if (result.resultCode == Activity.RESULT_OK) {
                feedViewModel.fetchRecords()
            }
        }

    private var newRecord: FloatingActionButton? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFeedBinding.inflate(layoutInflater)
        setContentView(binding?.root)

        feedViewModel
        newRecord = binding?.actionNewRecord

        supportFragmentManager.commit {
            replace(R.id.feedFragmentContainer, FeedFragment())
        }
        setupViews()
    }

    private fun setupViews() {
        newRecord?.setOnClickListener {
            onNewRecord()
        }
    }
    private fun onNewRecord() {
        val intent = Intent(this, RecordActivity::class.java)
        intent.putExtra(RecordActivity.ARG_DRIVER_ID, feedViewModel.getDriverId())
        startActivityCallBack.launch(intent)
    }

}
