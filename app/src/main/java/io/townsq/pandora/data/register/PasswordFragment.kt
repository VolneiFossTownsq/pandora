package io.townsq.pandora.data.register

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import androidx.navigation.fragment.findNavController
import io.townsq.pandora.R


class PasswordFragment : Fragment() {

    private var backRoleSelection: ImageView? = null
    private var goToConfirmation: Button? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val view = inflater.inflate(R.layout.fragment_personal_info, container, false)
        goToConfirmation = view?.findViewById(R.id.goToConfirmation)
        goToConfirmation?.setOnClickListener {
            onClickToPasswordFragment()
        }

        backRoleSelection = view?.findViewById(R.id.backToRoleSelection)
        backRoleSelection?.setOnClickListener {
            backToPersonalInfoFragment()
        }

        return view
    }

    fun onClickToPasswordFragment(){
        findNavController().navigate(R.id.action_passwordFragment_to_confirmationFragment)
    }

    fun backToPersonalInfoFragment(){
        findNavController().navigate(R.id.action_passwordFragment_to_roleSelectionFragment)
    }

}