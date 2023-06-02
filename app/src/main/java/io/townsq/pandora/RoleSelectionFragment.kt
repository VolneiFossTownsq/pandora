package io.townsq.pandora

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import androidx.navigation.fragment.findNavController

class RoleSelectionFragment : Fragment() {

    var returnToPersonalInfo: ImageView? = null
    var goToPassword: Button? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val view =  inflater.inflate(R.layout.fragment_role_selection, container, false)
        returnToPersonalInfo = view?.findViewById(R.id.backToPersonalInfo)
        returnToPersonalInfo?.setOnClickListener {
            backToPersonalInfo()
        }
        goToPassword = view?.findViewById(R.id.goToPassword)
        goToPassword?.setOnClickListener {
            goToPassword()
        }

        return view
    }

    fun backToPersonalInfo(){
        findNavController().navigate(R.id.action_roleSelectionFragment_to_personalInfoFragment)
    }

    fun goToPassword(){
        findNavController().navigate(R.id.action_roleSelectionFragment_to_passwordFragment)
    }


}