package com.example.dictionaryapp.data.repository

import com.example.dictionaryapp.data.client.DictionaryApi
import com.example.dictionaryapp.data.local.WordInfoDao
import com.example.dictionaryapp.data.model.remote.WordInfo
import com.example.dictionaryapp.utils.resource.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException

class WordInfoImplRepository(
    private val dao: WordInfoDao, private val dictionaryApi: DictionaryApi
) : WordInfoRepository {
    override fun getWordInfo(word: String): Flow<Resource<List<WordInfo>>> = flow {
        emit(Resource.Loading())
        val wordInfo = dao.getWordInfo(word).map { it.toWordInfo() }
        emit(Resource.Loading(wordInfo))
        try {
            val remoteWordInfo = dictionaryApi.getWordInformation(word)
            dao.deleteWordInfo(remoteWordInfo.map { it.word })
            dao.insetWordInfo(remoteWordInfo.map { it.toWordInfoEntity() })

        } catch (e: HttpException) {
            emit(Resource.Error("oops,something went wrong", wordInfo))
        } catch (e: IOException) {
            emit(Resource.Error("Could not reach server check your internet connection", wordInfo))
        }
        val newWordInfo = dao.getWordInfo(word = word).map { it.toWordInfo() }
        emit(Resource.Success(wordInfo))
    }
}