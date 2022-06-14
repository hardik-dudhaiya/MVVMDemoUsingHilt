package com.mind.minddemomvvm.ui.detail

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.mind.minddemomvvm.data.models.data.MemesItem
import javax.inject.Inject


class DetailViewModel @Inject constructor() : ViewModel() {

    private val meMeDetail = MutableLiveData<MemesItem>()
    val liveMemeDetail : LiveData<MemesItem> get() = meMeDetail

    fun setMemeDetail(memesItem: MemesItem) {
        meMeDetail.value =  memesItem
    }


}