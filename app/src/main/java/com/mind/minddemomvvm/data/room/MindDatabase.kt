package com.mind.minddemomvvm.data.room

import androidx.room.Database
import androidx.room.RoomDatabase
import com.mind.minddemomvvm.data.models.data.MemesItem
import com.mind.minddemomvvm.data.room.dao.MemeItemDao

@Database(entities = [MemesItem::class], version = 1)
abstract class MindDatabase : RoomDatabase() {

    abstract fun memeItemDao() : MemeItemDao

}
