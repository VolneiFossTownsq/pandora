package io.townsq.pandora

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController

class PersonalInfoFragment : Fragment() {

    var returnToLogin: ImageView? = null
    var goToRoleSelection: Button? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_personal_info, container, false)

        setupView(view)

        return view
    }

    private fun setupView(view: View) {
        returnToLogin = view.findViewById(R.id.backToLogin)
        returnToLogin?.setOnClickListener {
            Toast.makeText(activity, "Return Login", Toast.LENGTH_SHORT).show()
        }

        goToRoleSelection = view.findViewById<Button>(R.id.goToRoleSelection)
        goToRoleSelection?.setOnClickListener {
            onClickToRoleSelection()
        }
    }

    private fun onClickToRoleSelection() {
        Log.d("PersonalInfoFragment", "Button clicked")
        findNavController().navigate(R.id.action_personalInfoFragment_to_roleSelectionFragment)
    }

}