package io.townsq.pandora

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.AutoCompleteTextView
import android.widget.Button
import android.widget.ImageView
import androidx.navigation.fragment.findNavController

class RoleSelectionFragment : Fragment() {

    var textField: AutoCompleteTextView? = null
    var returnToPersonalInfo: ImageView? = null
    var goToPassword: Button? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view =  inflater.inflate(R.layout.fragment_role_selection, container, false)

        setupView(view)

        return view
    }

    private fun setupView(view:View){
        returnToPersonalInfo = view?.findViewById(R.id.backToPersonalInfo)
        returnToPersonalInfo?.setOnClickListener {
            backToPersonalInfo()
        }
        goToPassword = view?.findViewById(R.id.goToPassword)
        goToPassword?.setOnClickListener {
            goToPassword()
        }

        textField = view.findViewById(R.id.autoCompleteTextView)
        setItensDropMenu()

    }

    private fun setItensDropMenu(){
        val items = listOf("Admin", "Manager", "Employee")
        val adapter = ArrayAdapter(requireContext(), R.layout.list_item, R.id.itemTextView, items)
        textField?.setAdapter(adapter)
    }

    private fun backToPersonalInfo(){
        findNavController().navigate(R.id.action_roleSelectionFragment_to_personalInfoFragment)
    }

    private fun goToPassword(){
        findNavController().navigate(R.id.action_roleSelectionFragment_to_passwordFragment)
    }


}