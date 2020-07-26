package com.example.radiobuttonexperiment.ui.defaultradiobutton

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class DefaultRadioButtonViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "Default radio button fragment"
    }
    val text: LiveData<String> = _text
}