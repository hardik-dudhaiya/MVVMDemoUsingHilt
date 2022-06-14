package com.mind.minddemomvvm.data.models.responses

sealed class ResponseHandler<T>(val data: T? = null, val errorMessage: String? = null) {
    class Loading<T>() : ResponseHandler<T>()
    class Success<T>(data: T? = null) : ResponseHandler<T>(data = data)
    class Error<T>(errorMessage: String,data: T? = null) : ResponseHandler<T>(errorMessage = errorMessage, data = data)
}