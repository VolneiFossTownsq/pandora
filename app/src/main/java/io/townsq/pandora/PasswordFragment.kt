package io.townsq.pandora

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import androidx.navigation.fragment.findNavController

class PasswordFragment : Fragment() {

    private var backToRoleSelection: ImageView? = null
    private var goToConfirmation: Button? = null


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_password, container, false)

        setupView(view)

        return view
    }

    private fun setupView(view: View){
        backToRoleSelection = view.findViewById(R.id.backToRoleSelection)
        backToRoleSelection?.setOnClickListener {
            backToRoleSelection()
        }

        goToConfirmation = view.findViewById(R.id.goToConfirmation)
        goToConfirmation?.setOnClickListener {
            onClickToConfirmation()
        }
    }

    private fun backToRoleSelection(){
        findNavController().navigate(R.id.action_passwordFragment_to_roleSelectionFragment)
    }

    private fun onClickToConfirmation(){
        findNavController().navigate(R.id.action_passwordFragment_to_confirmationFragment)
    }

}