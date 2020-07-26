package com.example.radiobuttonexperiment.models

import com.example.radiobuttonexperiment.R


enum class Color(val colorName: String) {
    BLACK("Black"),
    RED("Red"),
    GREEN("Green"),
    BLUE("Blue")
}

val Color.resource
    get() = when(this) {
        Color.BLACK -> R.color.colorBlack
        Color.RED -> R.color.colorRed
        Color.GREEN -> R.color.colorGreen
        Color.BLUE -> R.color.colorBlue
    }