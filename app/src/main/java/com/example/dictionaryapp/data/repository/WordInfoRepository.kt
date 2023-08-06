package com.example.dictionaryapp.data.repository

import com.example.dictionaryapp.data.model.remote.WordInfo
import com.example.dictionaryapp.utils.resource.Resource
import kotlinx.coroutines.flow.Flow

interface WordInfoRepository {
    fun getWordInfo(word:String): Flow<Resource<List<WordInfo>>>
}