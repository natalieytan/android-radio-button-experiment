package com.example.radiobuttonexperiment.ui.customradiobutton

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class CustomRadioButtonViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "Custom radio button fragment"
    }
    val text: LiveData<String> = _text
}