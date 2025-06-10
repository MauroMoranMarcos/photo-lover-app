package com.example.photo_lover_app.data.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.photo_lover_app.data.db.dao.ImageDao
import com.example.photo_lover_app.data.db.dao.ReminderDao
import com.example.photo_lover_app.data.db.dao.UserDao
import com.example.photo_lover_app.data.db.entities.Image
import com.example.photo_lover_app.data.db.entities.Reminder
import com.example.photo_lover_app.data.db.entities.User

@Database(entities = [User::class, Image::class, Reminder::class], version = 1, exportSchema = false)
abstract class AppDatabase : RoomDatabase() {

    abstract fun userDao(): UserDao
    abstract fun imageDao(): ImageDao
    abstract fun reminderDao(): ReminderDao

    companion object {
        @Volatile
        private var Instance: AppDatabase? = null

        fun getDatabase(context: Context): AppDatabase {
            return Instance ?: synchronized(this) {
                Room.databaseBuilder(context, AppDatabase::class.java, "app_database")
                    .build()
                    .also { Instance = it }
            }
        }
    }

}