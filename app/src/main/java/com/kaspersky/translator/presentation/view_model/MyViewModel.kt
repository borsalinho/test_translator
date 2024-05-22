package com.kaspersky.translator.view_model

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.kaspersky.data.storage.model.TranslationEntity
import com.kaspersky.domain.model.WordQuerry
import com.kaspersky.domain.model.WordsResponce
import com.kaspersky.domain.usecases.SendWordUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class MyViewModel(
    private var sendWordUseCase : SendWordUseCase
) : ViewModel() {





    private val _translations = MutableLiveData<List<TranslationEntity>>()
    val translations: LiveData<List<TranslationEntity>> get() = _translations




    suspend fun sendWord(query : WordQuerry) : WordsResponce {
        return withContext(Dispatchers.IO){
            sendWordUseCase.execute(query)
        }
    }








    private val _text_1 = MutableLiveData<String>().apply {
        value = "This is home Fragment"
    }
    val text_1: LiveData<String> = _text_1

    private val _text_2 = MutableLiveData<String>().apply {
        value = "This is favorite Fragment"
    }
    val text_2: LiveData<String> = _text_2
}