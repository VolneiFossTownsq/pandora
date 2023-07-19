package io.townsq.pandora.ui.recordDetails

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.commit
import io.townsq.pandora.R
import io.townsq.pandora.databinding.ActivityRecordDetailsBinding
import org.koin.androidx.viewmodel.ext.android.viewModel
import org.koin.core.parameter.parametersOf

class RecordDetailsActivity : AppCompatActivity() {

    companion object {
        const val ARG_RECORD_ID = "recordId"
    }
    private val recordDetailsViewModel: RecordDetailsViewModel by viewModel {
        parametersOf(
            intent.extras?.getString(ARG_RECORD_ID)
        )
    }
    private var binding: ActivityRecordDetailsBinding? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRecordDetailsBinding.inflate(layoutInflater)
        setContentView(binding?.root)

        recordDetailsViewModel
        supportFragmentManager.commit {
            replace(R.id.recordDetailsFragmentContainer, RecordDetailsFragment())
        }
    }
}
