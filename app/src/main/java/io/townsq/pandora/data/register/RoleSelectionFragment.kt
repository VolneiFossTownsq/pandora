package io.townsq.pandora.data.register

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import io.townsq.pandora.R

class RoleSelectionFragment : Fragment() {

    private var backPersonalInfo: ImageView? = null
    private var goToPassword: Button? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_personal_info, container, false)
        goToPassword = view?.findViewById(R.id.goToPassword)
        goToPassword?.setOnClickListener {
            onClickToPasswordFragment()
        }

        backPersonalInfo = view?.findViewById(R.id.backToPersonalInfo)
        backPersonalInfo?.setOnClickListener {
            backToPersonalInfoFragment()
        }

        return view
    }

    fun onClickToPasswordFragment(){
        findNavController().navigate(R.id.action_roleSelectionFragment_to_passwordFragment)
    }

    fun backToPersonalInfoFragment(){
        findNavController().navigate(R.id.action_roleSelectionFragment_to_personalInfoFragment)
    }
}
