package io.townsq.pandora.components

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import io.townsq.pandora.R
import io.townsq.pandora.data.models.RecordType

class CardPandora @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : LinearLayout(context, attrs, defStyleAttr) {

    private var backgroundRecord: LinearLayout? = null
    private var recordIcon: ImageView? = null
    private var recordTypeText: TextView? = null
    private var recordType: RecordType? = null

    init {
        LayoutInflater.from(context).inflate(R.layout.card_pandora, this, true)

        backgroundRecord = findViewById(R.id.backgroundRecord)
        recordIcon = findViewById(R.id.iconOption)
        recordTypeText = findViewById(R.id.titleOption)
    }

    fun newInstance(recordType: RecordType) {
        this.recordType = recordType
        setupViews()
    }

    fun setColors(iconColor: Int, backgroundColor: Int) {
        backgroundRecord?.setBackgroundColor(backgroundColor)
        recordIcon?.setColorFilter(iconColor)
    }

    fun setTextColor(color: Int) {
        recordTypeText?.setTextColor(color)
    }

    private fun setupViews() {
        recordIcon?.setImageResource(setupIcon())
        recordTypeText?.text = setupString()
    }

    private fun setupString(): String? {
        return if (recordType?.type.toString().contains("Shift")) {
            "Shift"
        } else {
            recordType?.type
        }
    }

    private fun setupIcon(): Int {
        return when (recordType) {
            RecordType.MAINTENANCE -> {
                R.drawable.ic_maintenance
            }
            RecordType.GAS -> {
                R.drawable.ic_gas
            }
            else -> {
                R.drawable.ic_shift
            }
        }
    }
}
