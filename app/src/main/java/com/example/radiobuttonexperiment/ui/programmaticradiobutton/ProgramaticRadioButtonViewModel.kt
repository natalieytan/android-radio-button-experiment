package com.example.radiobuttonexperiment.ui.programmaticradiobutton

import android.os.Build
import android.view.View
import androidx.annotation.RequiresApi
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.radiobuttonexperiment.models.Color

interface ProgrammaticRadioButtonViewModel {
    val radioSelectionMap: Map<Int, Any?>
    fun valueOfRadioViewId(int: Int): Any?
}

class ProgramaticRadioButtonViewModel : ProgrammaticRadioButtonViewModel, ViewModel() {
    @RequiresApi(Build.VERSION_CODES.JELLY_BEAN_MR1)
    override val radioSelectionMap = SELECTABLE_COLORS.map { View.generateViewId() to it }.toMap()

    override fun valueOfRadioViewId(int: Int) : Color? = radioSelectionMap[int]

    private val _selectedColor = MutableLiveData<Color>().apply {
        value = Color.BLACK
    }
    val selectedColor: LiveData<Color>
        get() = _selectedColor

    fun displayString(): String { return "Selected color is ${selectedColor.value!!.colorName}" }

    fun setSelectedColor(color: Color) {
        _selectedColor.value = color
    }

    companion object {
        val SELECTABLE_COLORS = listOf(
            Color.BLACK,
            Color.RED,
            Color.BLUE,
            Color.GREEN
        )
    }
}