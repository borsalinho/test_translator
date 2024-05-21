package com.kaspersky.translator.view_model

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MyViewModel : ViewModel() {

    private val _text_1 = MutableLiveData<String>().apply {
        value = "This is home Fragment"
    }
    val text_1: LiveData<String> = _text_1

    private val _text_2 = MutableLiveData<String>().apply {
        value = "This is favorite Fragment"
    }
    val text_2: LiveData<String> = _text_2
}