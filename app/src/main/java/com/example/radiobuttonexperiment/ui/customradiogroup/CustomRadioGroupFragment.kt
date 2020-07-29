package com.example.radiobuttonexperiment.ui.customradiogroup

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.example.radiobuttonexperiment.R
import kotlinx.android.synthetic.main.fragment_custom_radio_group.*

class CustomRadioGroupFragment : Fragment() {

    private lateinit var viewModel: CustomRadioGroupViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        viewModel =
            ViewModelProviders.of(this).get(CustomRadioGroupViewModel::class.java)
        return inflater.inflate(R.layout.fragment_custom_radio_group, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        Log.i("DEBUG", "OnViewCreated Called")
        super.onViewCreated(view, savedInstanceState)
        buttonApplyColor.isEnabled = false
        radioGroupColors.apply {
            setComponentViewModel(viewModel.radioSelectionMap)
            setRadioButtonSelectedListener { key ->
                buttonApplyColor.isEnabled = when (key) {
                    viewModel.selectedKey.value -> false
                    else -> true
                }
                viewModel.checkedKey = key
            }
            viewModel.checkedKey?.let { setRadioButton(it) }
        }

        viewModel.selectedKey.observe(viewLifecycleOwner, Observer {
            textViewInfo.text = viewModel.displayString()
            viewModel.colorResource()?.let {
                textViewInfo.setTextColor(ContextCompat.getColor(requireContext(), it))
            }
        })

        buttonApplyColor.setOnClickListener {
            val chosenKey = radioGroupColors.selectedKey()
            chosenKey?.let {
                viewModel.setSelectedColor(it)
            }
            buttonApplyColor.isEnabled = false
        }
    }
}