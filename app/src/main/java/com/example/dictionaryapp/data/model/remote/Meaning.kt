package com.example.dictionaryapp.data.model.remote

data class Meaning(
    val definitions: List<Definition>,
    val partOfSpeech: String
)