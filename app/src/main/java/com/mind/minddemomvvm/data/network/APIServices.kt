package com.mind.minddemomvvm.data.network

import com.mind.minddemomvvm.data.models.responses.MemesResponse
import retrofit2.http.GET

interface APIServices {

    @GET(EndPoints.GET_MEMES)
    suspend fun getMemes(): MemesResponse

}