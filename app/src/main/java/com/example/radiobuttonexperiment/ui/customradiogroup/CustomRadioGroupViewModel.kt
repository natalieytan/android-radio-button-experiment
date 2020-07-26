package com.example.radiobuttonexperiment.ui.customradiogroup

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class CustomRadioGroupViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "Custom radio group fragment"
    }
    val text: LiveData<String> = _text
}