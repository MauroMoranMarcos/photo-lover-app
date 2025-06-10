package com.example.photo_lover_app.data.repository

import com.example.photo_lover_app.data.db.dao.ImageDao
import com.example.photo_lover_app.data.db.entities.Image
import kotlinx.coroutines.flow.Flow

class OfflineImagesRepository(private val imageDao: ImageDao) : ImagesRepository {
    override fun getImageStream(id: Int): Flow<Image> {
        return imageDao.getImage(id)
    }

    override fun getImagesFromUser(userId: Int): Flow<List<Image>> {
        return imageDao.getImagesFromUser(userId)
    }

    override suspend fun insertImage(image: Image) {
        return imageDao.insert(image)
    }

    override suspend fun updateImage(image: Image) {
        return imageDao.update(image)
    }

    override suspend fun deleteImage(image: Image) {
        return imageDao.delete(image)
    }
}