package com.mind.minddemomvvm.data.room.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.mind.minddemomvvm.data.models.data.MemesItem

@Dao
interface MemeItemDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertMeme(memesItem: MemesItem): Long

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAllMemes(memesItem: List<MemesItem>)

    @Query("Select * from memesitem")
    fun getData() : LiveData<List<MemesItem>>

}