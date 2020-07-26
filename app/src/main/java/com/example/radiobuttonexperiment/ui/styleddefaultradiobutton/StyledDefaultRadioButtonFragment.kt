package com.example.radiobuttonexperiment.ui.styleddefaultradiobutton

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.example.radiobuttonexperiment.R

class StyledDefaultRadioButtonFragment : Fragment() {

    private lateinit var styledDefaultRadioButtonViewModel: StyledDefaultRadioButtonViewModel

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        styledDefaultRadioButtonViewModel =
                ViewModelProviders.of(this).get(StyledDefaultRadioButtonViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_styled_default_radio_button, container, false)
        val textView: TextView = root.findViewById(R.id.textViewInfo)
        styledDefaultRadioButtonViewModel.text.observe(viewLifecycleOwner, Observer {
            textView.text = it
        })
        return root
    }
}