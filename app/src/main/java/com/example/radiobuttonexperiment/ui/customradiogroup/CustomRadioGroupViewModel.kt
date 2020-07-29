package com.example.radiobuttonexperiment.ui.customradiogroup

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.radiobuttonexperiment.models.Color
import com.example.radiobuttonexperiment.models.resource

class CustomRadioGroupViewModel : ViewModel() {
    val radioSelectionMap =
        SELECTABLE_COLORS.mapIndexed { i, color -> "$i" to color.colorName }.toMap()
    val mapToValues = SELECTABLE_COLORS.mapIndexed { i, color -> "$i" to color }.toMap()

    private val _selectedKey = MutableLiveData<String?>().apply {
        value = mapToValues.filterValues { it == Color.BLACK }.keys.firstOrNull()
    }
    val selectedKey: LiveData<String?>
        get() = _selectedKey

    var checkedKey = mapToValues.filterValues { it == Color.BLACK }.keys.firstOrNull()

    fun displayString(): String {
        val color = selectedKey.let { radioSelectionMap[it.value] } ?: "none"
        return "Selected color is $color"
    }

    fun setSelectedColor(key: String) {
        _selectedKey.value = key
    }

    fun colorResource() = mapToValues[selectedKey.value]?.resource

    companion object {
        val SELECTABLE_COLORS = listOf(
            Color.BLACK,
            Color.RED,
            Color.BLUE,
            Color.GREEN
        )
    }
}