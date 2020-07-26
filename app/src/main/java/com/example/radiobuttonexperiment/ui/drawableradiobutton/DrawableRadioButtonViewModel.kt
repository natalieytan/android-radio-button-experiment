package com.example.radiobuttonexperiment.ui.drawableradiobutton

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.radiobuttonexperiment.models.Color

class DrawableRadioButtonViewModel : ViewModel() {

    private val _selectedColor = MutableLiveData<Color>().apply {
        value = Color.BLACK
    }
    val selectedColor: LiveData<Color>
        get() = _selectedColor

    fun displayString(): String { return "Selected color is ${selectedColor.value!!.colorName}" }

    fun setSelectedColor(color: Color) {
        _selectedColor.value = color
    }
}