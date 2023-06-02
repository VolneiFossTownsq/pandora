package io.townsq.pandora

import android.graphics.Color
import android.os.Bundle
import android.text.Html
import android.text.Spannable
import android.text.SpannableStringBuilder
import android.text.style.ForegroundColorSpan
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.core.text.HtmlCompat
import androidx.navigation.fragment.findNavController

class ConfirmationFragment : Fragment() {

    private var backToPassword: ImageView? = null
    private var goToLogin: Button? = null
    private var titleConfirmation: TextView? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_confirmation, container, false)

        backToPassword = view.findViewById(R.id.backToPassword)
        backToPassword?.setOnClickListener {
            backToRoleSelection()
        }

        goToLogin = view.findViewById(R.id.goToLogin)
        goToLogin?.setOnClickListener {
            login()
        }

        return view
    }

    fun backToRoleSelection() {
        findNavController().navigate(R.id.action_confirmationFragment_to_passwordFragment)
    }

    fun login() {
        Toast.makeText(activity, "Login", Toast.LENGTH_SHORT).show()
    }



}