package com.example.dictionaryapp.utils

import androidx.room.ProvidedTypeConverter
import androidx.room.TypeConverter
import com.example.dictionaryapp.data.model.remote.Meaning
import com.example.dictionaryapp.utils.json.JsonParser
import com.google.gson.reflect.TypeToken

@ProvidedTypeConverter
class Converters(private val jsonParser: JsonParser) {
    @TypeConverter
    fun fromMeaningsJson(json: String): List<Meaning> = jsonParser.fromJson<ArrayList<Meaning>>(
        json, type = object : TypeToken<ArrayList<Meaning>>() {}.type
    ) ?: emptyList()


    @TypeConverter
    fun toMeaningsJson(meaning: List<Meaning>): String = jsonParser.toJson(
        objects = meaning,
        type = object : TypeToken<ArrayList<Meaning>>() {}.type
    ) ?: "[]"
}