package com.example.photo_lover_app.ui.home

import androidx.lifecycle.ViewModel
import com.example.photo_lover_app.data.db.entities.Image

class HomeViewModel : ViewModel() {
    companion object {
        private const val TIMEOUT_MILLIS = 5_000L
    }
}

data class HomeUiState(val imageList: List<Image> = listOf())