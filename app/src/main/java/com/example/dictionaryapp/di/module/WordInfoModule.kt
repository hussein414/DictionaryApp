package com.example.dictionaryapp.di.module

import android.app.Application
import androidx.room.Room
import com.example.dictionaryapp.data.client.DictionaryApi
import com.example.dictionaryapp.data.local.WordInfoDao
import com.example.dictionaryapp.data.local.WordInfoDatabase
import com.example.dictionaryapp.data.repository.WordInfoImplRepository
import com.example.dictionaryapp.data.repository.WordInfoRepository
import com.example.dictionaryapp.data.usecase.GetWordInfo
import com.example.dictionaryapp.utils.Constance
import com.example.dictionaryapp.utils.json.GsonParser
import com.google.gson.Gson
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object WordInfoModule {

    @Provides
    @Singleton
    fun providesGetWordInfoUsaCase(repository: WordInfoRepository): GetWordInfo =
        GetWordInfo(repository)

    @Provides
    @Singleton
    fun providesGetWordInfoRepository(
        database: WordInfoDatabase, api: DictionaryApi
    ): WordInfoRepository = WordInfoImplRepository(database.wordInfoDao, api)

    @Provides
    @Singleton
    fun providesGetWordInfoDatabase(application: Application): WordInfoDatabase =
        Room.databaseBuilder(application, WordInfoDatabase::class.java, "word_db").addTypeConverter(
                GsonParser(Gson())).build()

    @Provides
    @Singleton
    fun providesDictionaryApi(): DictionaryApi = Retrofit.Builder().baseUrl(Constance.BASE_URL)
        .addConverterFactory(GsonConverterFactory.create()).build()
        .create(DictionaryApi::class.java)

}