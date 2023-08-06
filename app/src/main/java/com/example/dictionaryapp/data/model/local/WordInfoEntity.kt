package com.example.dictionaryapp.data.model.local

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.dictionaryapp.data.model.remote.Meaning
import com.example.dictionaryapp.data.model.remote.WordInfo

@Entity
data class WordInfoEntity(
    val word: String,
    val phonetic: String,
    val origin: String,
    val meanings: List<Meaning>,
    @PrimaryKey val id: Int? = null
) {
    fun toWordInfo(): WordInfo {
        return WordInfo(
            meanings = meanings,
            word = word,
            origin = origin,
            phonetic = phonetic
        )
    }
}