package io.townsq.pandora.ui.feed

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.commit
import io.townsq.pandora.R
import io.townsq.pandora.databinding.ActivityFeedBinding

class FeedActivity : AppCompatActivity() {

    private var binding: ActivityFeedBinding? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFeedBinding.inflate(layoutInflater)
        setContentView(binding?.root)

        supportFragmentManager.commit {
            replace(R.id.feedFragmentContainer, FeedFragment())
        }
    }
}
