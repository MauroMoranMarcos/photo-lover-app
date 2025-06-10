package com.example.photo_lover_app.data.db.dao

import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.example.photo_lover_app.data.db.entities.Reminder
import kotlinx.coroutines.flow.Flow

interface ReminderDao {

    @Insert
    suspend fun insert(reminder: Reminder)

    @Update
    suspend fun update(reminder: Reminder)

    @Delete
    suspend fun delete(reminder: Reminder)

    @Query("SELECT * from reminders WHERE id = :id")
    fun getReminder(id: Int): Flow<Reminder>

    @Query("SELECT * from reminders WHERE userId = :userId")
    fun getRemindersFromUser(userId: Int): Flow<List<Reminder>>

}