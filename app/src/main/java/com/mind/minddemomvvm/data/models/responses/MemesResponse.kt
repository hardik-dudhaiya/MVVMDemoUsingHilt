package com.mind.minddemomvvm.data.models.responses

import com.google.gson.annotations.SerializedName
import com.mind.minddemomvvm.data.models.data.MemesData

data class MemesResponse(
    @SerializedName("success") var isSuccess: Boolean = false,
    @SerializedName("data") var data: MemesData? = MemesData(),
)
