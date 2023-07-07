package com.example.viewmodelex

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class AppScreenViewModel : ViewModel() {
    val count = MutableLiveData(0)

    fun countUp() {
        val num = count.value ?: 0
        count.value = num + 1
    }
}