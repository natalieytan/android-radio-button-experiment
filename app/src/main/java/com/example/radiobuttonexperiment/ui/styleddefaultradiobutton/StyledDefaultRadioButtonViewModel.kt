package com.example.radiobuttonexperiment.ui.styleddefaultradiobutton

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class StyledDefaultRadioButtonViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "Styled default radio button fragment"
    }
    val text: LiveData<String> = _text
}