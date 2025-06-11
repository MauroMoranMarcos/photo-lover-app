package com.example.photo_lover_app.data.db.container

import android.content.Context
import com.example.photo_lover_app.data.db.AppDatabase
import com.example.photo_lover_app.data.repository.ImagesRepository
import com.example.photo_lover_app.data.repository.OfflineImagesRepository
import com.example.photo_lover_app.data.repository.OfflineRemindersRepository
import com.example.photo_lover_app.data.repository.OfflineUsersRepository
import com.example.photo_lover_app.data.repository.RemindersRepository
import com.example.photo_lover_app.data.repository.UsersRepository

interface AppContainer {
    val imagesRepository: ImagesRepository
    val remindersRepository: RemindersRepository
    val usersRepository: UsersRepository
}

class AppDataContainer(private val context: Context) : AppContainer {

    override val imagesRepository: ImagesRepository by lazy {
        OfflineImagesRepository(AppDatabase.getDatabase(context).imageDao())
    }

    override val remindersRepository: RemindersRepository by lazy {
        OfflineRemindersRepository(AppDatabase.getDatabase(context).reminderDao())
    }

    override val usersRepository: UsersRepository by lazy {
        OfflineUsersRepository(AppDatabase.getDatabase(context).userDao())
    }

}