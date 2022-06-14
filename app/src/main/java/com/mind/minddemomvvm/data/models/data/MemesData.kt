package com.mind.minddemomvvm.data.models.data

import com.google.gson.annotations.SerializedName

class MemesData {

    @SerializedName("memes")
    var memesList: ArrayList<MemesItem> = arrayListOf()
}