package com.example.dictionaryapp.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverter
import androidx.room.TypeConverters
import com.example.dictionaryapp.data.model.local.WordInfoEntity
import com.example.dictionaryapp.utils.Converters

@Database(entities = [WordInfoEntity::class], version = 1)
@TypeConverters(Converters::class)
abstract class WordInfoDatabase : RoomDatabase() {
    abstract val wordInfoDao: WordInfoDao
}