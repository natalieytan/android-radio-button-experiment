package com.example.radiobuttonexperiment.ui.programmaticradiobutton

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.RadioButton
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.example.radiobuttonexperiment.R
import com.example.radiobuttonexperiment.models.resource
import kotlinx.android.synthetic.main.fragment_programmatic_radio_button.*

class ProgrammaticRadioButtonFragment : Fragment() {

    private lateinit var programmaticRadioButtonViewModel: ProgramaticRadioButtonViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        programmaticRadioButtonViewModel =
            ViewModelProviders.of(this).get(ProgramaticRadioButtonViewModel::class.java)
        return inflater.inflate(R.layout.fragment_programmatic_radio_button, container, false)
    }

    @SuppressLint("NewApi")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        programmaticRadioButtonViewModel.radioSelectionMap
            .forEach { (viewId, Color) ->
                radioGroupColors.addView(
                    createRadioButton(Color.colorName, viewId)
                )
            }

        buttonApplyColor.isEnabled = false

        programmaticRadioButtonViewModel.selectedColor.observe(viewLifecycleOwner, Observer {
            textViewInfo.text = programmaticRadioButtonViewModel.displayString()
            textViewInfo.setTextColor(ContextCompat.getColor(requireContext(), it.resource))
        })

        radioGroupColors.setOnCheckedChangeListener { _, selectedRadio ->
            buttonApplyColor.isEnabled =
                when (programmaticRadioButtonViewModel.valueOfRadioViewId(selectedRadio)) {
                    programmaticRadioButtonViewModel.selectedColor.value!! -> false
                    else -> true
                }
        }

        buttonApplyColor.setOnClickListener {
            val chosenColor =
                programmaticRadioButtonViewModel.valueOfRadioViewId(radioGroupColors.checkedRadioButtonId)
            programmaticRadioButtonViewModel.setSelectedColor(chosenColor!!)
            buttonApplyColor.isEnabled = false
        }
    }

    private fun createRadioButton(string: String, viewId: Int): RadioButton {
        val radio = layoutInflater.inflate(R.layout.radio_button_template, null) as RadioButton
        radio.text = string
        radio.id = viewId
        radio.layoutParams = LinearLayout.LayoutParams(
            LinearLayout.LayoutParams.MATCH_PARENT,
            LinearLayout.LayoutParams.WRAP_CONTENT
        )
        return radio
    }


}