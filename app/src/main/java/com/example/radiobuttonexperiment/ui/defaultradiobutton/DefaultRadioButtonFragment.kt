package com.example.radiobuttonexperiment.ui.defaultradiobutton

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.example.radiobuttonexperiment.R

class DefaultRadioButtonFragment : Fragment() {

    private lateinit var defaultRadioButtonViewModel: DefaultRadioButtonViewModel

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        defaultRadioButtonViewModel =
                ViewModelProviders.of(this).get(DefaultRadioButtonViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_default_radio_button, container, false)
        val textView: TextView = root.findViewById(R.id.textViewInfo)
        defaultRadioButtonViewModel.text.observe(viewLifecycleOwner, Observer {
            textView.text = it
        })
        return root
    }
}