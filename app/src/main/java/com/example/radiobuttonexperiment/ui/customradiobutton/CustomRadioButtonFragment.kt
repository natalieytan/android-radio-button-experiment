package com.example.radiobuttonexperiment.ui.customradiobutton

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.example.radiobuttonexperiment.R

class CustomRadioButtonFragment : Fragment() {

    private lateinit var customRadioButtonViewModel: CustomRadioButtonViewModel

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        customRadioButtonViewModel =
                ViewModelProviders.of(this).get(CustomRadioButtonViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_custom_radio_button, container, false)
        val textView: TextView = root.findViewById(R.id.textViewInfo)
        customRadioButtonViewModel.text.observe(viewLifecycleOwner, Observer {
            textView.text = it
        })
        return root
    }
}