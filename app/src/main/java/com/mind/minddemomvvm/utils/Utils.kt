package com.mind.minddemomvvm.utils


import com.google.gson.Gson

object Utils {

    fun <T> getObjectFromData(data: Any?, type: Class<T>): T =
        Gson().fromJson(Gson().toJson(data),type)

}