package com.example.radiobuttonexperiment.ui.customradiogroup

import android.annotation.SuppressLint
import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.view.View
import android.widget.LinearLayout
import android.widget.RadioButton
import android.widget.RadioGroup
import com.example.radiobuttonexperiment.R

class CustomRadioGroup @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null
) : RadioGroup(context, attrs) {

    private var viewIdToKey: MutableMap<Int, String> = mutableMapOf()
    private var keyToViewId: MutableMap<String, Int> = mutableMapOf()

    @SuppressLint("NewApi")
    fun setComponentViewModel(data: Map<String, String>) {
        data.forEach { (key, value) ->
            val viewId = View.generateViewId()
            addRadioButton(viewId, value)
            viewIdToKey[viewId] = key
            keyToViewId[key] = viewId
        }
    }

    fun setRadioButton(key: String) {
        getViewIdByKey(key)?.let { this.check(it) }
    }

    fun setRadioButtonSelectedListener(listener: (String) -> Unit) {
        this.setOnCheckedChangeListener { _, viewId ->
            val string = getKeyByViewId(viewId)
            string?.let(listener)
        }
    }

    fun selectedKey() = viewIdToKey[this.checkedRadioButtonId]

    private fun getKeyByViewId(viewId: Int) = viewIdToKey[viewId]

    private fun getViewIdByKey(key: String) = keyToViewId[key]

    private fun addRadioButton(viewId: Int, string: String) {
        val layoutInflater = LayoutInflater.from(context)
        val radioButton =
            layoutInflater.inflate(R.layout.radio_button_template, null) as RadioButton
        radioButton.text = string
        radioButton.id = viewId
        radioButton.layoutParams = LinearLayout.LayoutParams(
            LinearLayout.LayoutParams.MATCH_PARENT,
            LinearLayout.LayoutParams.WRAP_CONTENT
        )
        this.addView(radioButton)
    }
}