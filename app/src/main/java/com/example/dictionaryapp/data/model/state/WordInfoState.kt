package com.example.dictionaryapp.data.model.state

import com.example.dictionaryapp.data.model.remote.WordInfo
import com.example.dictionaryapp.data.usecase.GetWordInfo
import com.example.dictionaryapp.utils.resource.Resource

data class WordInfoState(
    val wordInfoItems: List<WordInfo> = emptyList(),
    val isLoading: Boolean = false
)
