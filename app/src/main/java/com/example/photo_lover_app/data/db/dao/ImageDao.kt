package com.example.photo_lover_app.data.db.dao

import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.example.photo_lover_app.data.db.entities.Image
import kotlinx.coroutines.flow.Flow

interface ImageDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(image: Image)

    @Update
    suspend fun update(image: Image)

    @Delete
    suspend fun delete(image: Image)

    @Query("SELECT * from images WHERE id = :id")
    fun getImage(id: Int): Flow<Image>

    // Meter ORDER BY??
    @Query("SELECT * from images WHERE userId = :userId")
    fun getImagesFromUser(userId: Int): Flow<List<Image>>

}