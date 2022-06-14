package com.mind.minddemomvvm.ui.home

import androidx.lifecycle.LiveData
import com.mind.minddemomvvm.data.models.data.MemesItem
import com.mind.minddemomvvm.data.models.responses.MemesResponse
import com.mind.minddemomvvm.data.network.APIServices
import com.mind.minddemomvvm.data.room.MindDatabase
import javax.inject.Inject

class HomeRepository @Inject constructor(
    private val apiServices: APIServices,
    private val mindDatabase: MindDatabase
) {

        suspend fun getMemesFromApi() : MemesResponse
        {
            return apiServices.getMemes()
        }

    fun getMemes() : LiveData<List<MemesItem>>
    {
        return mindDatabase.memeItemDao().getData()
    }
}