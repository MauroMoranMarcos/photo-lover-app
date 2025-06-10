package com.example.photo_lover_app.data.repository

import com.example.photo_lover_app.data.db.entities.Image
import kotlinx.coroutines.flow.Flow

interface ImagesRepository {

    fun getImageStream(id: Int): Flow<Image>

    fun getImagesFromUser(userId: Int): Flow<List<Image>>

    suspend fun insertImage(image: Image)

    suspend fun updateImage(image: Image)

    suspend fun deleteImage(image: Image)

}