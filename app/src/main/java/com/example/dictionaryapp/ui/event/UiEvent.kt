package com.example.dictionaryapp.ui.event

import android.os.Message

sealed class UiEvent {
    data class ShowSnackBar(val message: String) : UiEvent()
}
