package com.example.dictionaryapp.data.client

import com.example.dictionaryapp.data.model.local.dto.WordInfoDto
import com.example.dictionaryapp.utils.Constance
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface DictionaryApi {
    @GET(Constance.END_POINT)
    suspend fun getWordInformation(@Path("word") word: String): List<WordInfoDto>
}