package io.townsq.pandora.data.register

import android.media.Image
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import androidx.navigation.fragment.findNavController
import io.townsq.pandora.R

class PersonalInfoFragment : Fragment() {

    private var backLogin: ImageView? = null
    private var goToRoleSelection : Button? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_personal_info, container, false)
        goToRoleSelection = view?.findViewById(R.id.goToRoleSelection)
        goToRoleSelection?.setOnClickListener {
            onClickToRoleFragment()
        }

        backLogin = view?.findViewById(R.id.backToLogin)
        backLogin?.setOnClickListener {
            backToLoginFragment()
        }

        return view
    }

    fun onClickToRoleFragment() {
        findNavController().navigate(R.id.action_personalInfoFragment_to_roleSelectionFragment)
    }

    fun backToLoginFragment(){
        findNavController().navigate(R.id.action_personalInfoFragment_to_loginFragment)
    }

}