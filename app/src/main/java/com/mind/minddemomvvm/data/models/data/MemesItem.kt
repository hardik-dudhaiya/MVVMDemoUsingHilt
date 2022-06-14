package com.mind.minddemomvvm.data.models.data

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity
data class MemesItem(

    @PrimaryKey
    @SerializedName("id") var id: String,
    @SerializedName("name") var name: String? = null,
    @SerializedName("url") var url: String? = null,
    @SerializedName("width") var width: Int? = null,
    @SerializedName("height") var height: Int? = null,
    @SerializedName("box_count") var boxCount: Int? = null
)