package com.example.radiobuttonexperiment.ui.styledradiobutton

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.example.radiobuttonexperiment.R
import com.example.radiobuttonexperiment.models.Color
import com.example.radiobuttonexperiment.models.resource
import kotlinx.android.synthetic.main.fragment_styled_radio_button.*

class UnstyledRadioButtonFragment : Fragment() {

    private lateinit var unstyledRadioButtonViewModel: UnstyledRadioButtonViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        unstyledRadioButtonViewModel =
            ViewModelProviders.of(this).get(UnstyledRadioButtonViewModel::class.java)
        return inflater.inflate(R.layout.fragment_unstyled_radio_button, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        buttonApplyColor.isEnabled = false
        radioGroupColors.check(getRadioButtonViewId(unstyledRadioButtonViewModel.selectedColor.value!!));

        unstyledRadioButtonViewModel.selectedColor.observe(viewLifecycleOwner, Observer {
            textViewInfo.text = unstyledRadioButtonViewModel.displayString()
            textViewInfo.setTextColor(ContextCompat.getColor(requireContext(), it.resource))
        })

        radioGroupColors.setOnCheckedChangeListener { _, selectedRadio ->
            buttonApplyColor.isEnabled = when (getColor(selectedRadio)) {
                unstyledRadioButtonViewModel.selectedColor.value!! -> false
                else -> true
            }
        }

        buttonApplyColor.setOnClickListener {
            val chosenColor = getColor(radioGroupColors.checkedRadioButtonId)
            unstyledRadioButtonViewModel.setSelectedColor(chosenColor)
            buttonApplyColor.isEnabled = false
        }
    }

    private fun getRadioButtonViewId(color: Color) = when (color) {
        Color.BLACK -> R.id.radioButtonBlack
        Color.RED -> R.id.radioButtonRed
        Color.GREEN -> R.id.radioButtonGreen
        Color.BLUE -> R.id.radioButtonBlue
    }

    private fun getColor(view: Int) = when (view) {
        R.id.radioButtonBlack -> Color.BLACK
        R.id.radioButtonRed -> Color.RED
        R.id.radioButtonGreen -> Color.GREEN
        R.id.radioButtonBlue -> Color.BLUE
        else -> Color.BLACK
    }
}