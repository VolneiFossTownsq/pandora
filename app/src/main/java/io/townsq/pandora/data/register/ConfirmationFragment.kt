package io.townsq.pandora.data.register

import android.graphics.Color
import android.os.Bundle
import android.text.SpannableStringBuilder
import android.text.style.ForegroundColorSpan
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import io.townsq.pandora.R
import org.w3c.dom.Text


class ConfirmationFragment : Fragment() {

    private var titleConfirmation: TextView? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_confirmation, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setTextColor()
    }

    fun setTextColor() {
        val frase = "The user has been successfully registered to Pandora"
        val colorHex = "#E24C44"

        val builder = SpannableStringBuilder(frase)
        val start = frase.indexOf("Pandora")
        val end = start + "Pandora".length

        val colorInt = Color.parseColor(colorHex)
        val span = ForegroundColorSpan(colorInt)
        builder.setSpan(span, start, end, SpannableStringBuilder.SPAN_EXCLUSIVE_EXCLUSIVE)

        titleConfirmation = view?.findViewById(R.id.titleConfirmation)
        titleConfirmation?.text = builder
    }
}

