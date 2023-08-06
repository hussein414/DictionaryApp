package com.example.dictionaryapp.data.usecase

import com.example.dictionaryapp.data.model.remote.WordInfo
import com.example.dictionaryapp.data.repository.WordInfoRepository
import com.example.dictionaryapp.utils.resource.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class GetWordInfo(private val repository: WordInfoRepository) {
    operator fun invoke(word: String): Flow<Resource<List<WordInfo>>> {
        if (word.isBlank()) {
            return flow {}
        }
        return repository.getWordInfo(word)
    }
}