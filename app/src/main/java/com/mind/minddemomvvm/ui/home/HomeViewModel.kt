package com.mind.minddemomvvm.ui.home

import android.content.Context
import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mind.minddemomvvm.data.room.MindDatabase
import com.mind.minddemomvvm.utils.NetworkUtils
import dagger.hilt.android.lifecycle.HiltViewModel
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val homeRepository: HomeRepository,
    @ApplicationContext val context: Context,
    val mindDatabase: MindDatabase
) : ViewModel() {
    init {

        getMemesFromApi()
    }
    fun getMemes() = homeRepository.getMemes()

    fun getMemesFromApi() {
      viewModelScope.launch {

            if (NetworkUtils.isInternetConnected(context)) {

                try {
                    val result = homeRepository.getMemesFromApi()

                    if (result.isSuccess) {
                            result.data?.memesList?.let { it1 ->
                                mindDatabase.memeItemDao().insertAllMemes(
                                    it1.toList())
                            }
                    }
                } catch (exception: Exception) {
                    exception.message?.let { Log.d("Error", it) }
                }

            } else {
               Log.d("Error","Internet not available")
            }

        }
    }
}