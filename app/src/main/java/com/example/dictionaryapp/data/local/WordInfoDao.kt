package com.example.dictionaryapp.data.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.dictionaryapp.data.model.local.WordInfoEntity

@Dao
interface WordInfoDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insetWordInfo(wordInfoEntity: List<WordInfoEntity>)

    @Query("delete from WordInfoEntity where word in (:words)")
    suspend fun deleteWordInfo(words: List<String>)


    @Query("select * from WordInfoEntity where word like '%'||:word||'%'")
    suspend fun getWordInfo(word: String): List<WordInfoEntity>

}