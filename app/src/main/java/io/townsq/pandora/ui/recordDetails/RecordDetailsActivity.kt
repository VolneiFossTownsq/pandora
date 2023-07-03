package io.townsq.pandora.ui.recordDetails

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.commit
import io.townsq.pandora.R
import io.townsq.pandora.databinding.ActivityRecordDetailsBinding

class RecordDetailsActivity : AppCompatActivity() {

    private var binding: ActivityRecordDetailsBinding? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRecordDetailsBinding.inflate(layoutInflater)
        setContentView(binding?.root)

        supportFragmentManager.commit {
            replace(R.id.recordDetailsFragmentContainer, RecordDetailsFragment())
        }
    }
}
