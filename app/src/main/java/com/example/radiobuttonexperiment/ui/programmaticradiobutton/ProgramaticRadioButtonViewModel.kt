package com.example.radiobuttonexperiment.ui.programmaticradiobutton

import android.os.Build
import android.view.View
import androidx.annotation.RequiresApi
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.radiobuttonexperiment.models.Color

class ProgramaticRadioButtonViewModel : ViewModel() {
    val selectableColors = listOf(
        Color.BLACK,
        Color.RED,
        Color.BLUE,
        Color.GREEN
    )

    @RequiresApi(Build.VERSION_CODES.JELLY_BEAN_MR1)
    var colorViewIds: List<Int> = IntArray(selectableColors.size) { View.generateViewId() }.asList()

    private val _selectedColor = MutableLiveData<Color>().apply {
        value = Color.BLACK
    }
    val selectedColor: LiveData<Color>
        get() = _selectedColor

    fun displayString(): String { return "Selected color is ${selectedColor.value!!.colorName}" }

    fun setSelectedColor(color: Color) {
        _selectedColor.value = color
    }

    fun colorByViewId(int: Int) : Color {
        val id = colorViewIds.indexOf(int)
        return selectableColors.get(id)
    }
}