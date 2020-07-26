package com.example.radiobuttonexperiment.ui.customradiogroup

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.example.radiobuttonexperiment.R

class CustomRadioGroupFragment : Fragment() {

    private lateinit var customRadioGroupViewModel: CustomRadioGroupViewModel

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        customRadioGroupViewModel =
                ViewModelProviders.of(this).get(CustomRadioGroupViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_custom_radio_group, container, false)
        val textView: TextView = root.findViewById(R.id.textViewInfo)
        customRadioGroupViewModel.text.observe(viewLifecycleOwner, Observer {
            textView.text = it
        })
        return root
    }
}