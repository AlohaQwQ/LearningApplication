package com.star.learningapplication.mvvm.viewmodel

import android.content.ClipData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class SharedViewModel: ViewModel() {

    val selected = MutableLiveData<ClipData.Item>()
    var hello: MutableLiveData<String>? = null;

    fun select(item: ClipData.Item) {
        selected.value = item
    }

}