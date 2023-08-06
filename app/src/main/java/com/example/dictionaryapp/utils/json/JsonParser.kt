package com.example.dictionaryapp.utils.json

import java.lang.reflect.Type

interface JsonParser {
    fun <T> fromJson(json: String, type: Type): T?
    fun <T> toJson(objects: T, type: Type): String?
}