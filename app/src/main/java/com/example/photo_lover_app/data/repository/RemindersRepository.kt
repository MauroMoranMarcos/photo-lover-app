package com.example.photo_lover_app.data.repository

import com.example.photo_lover_app.data.db.entities.Reminder
import kotlinx.coroutines.flow.Flow

interface RemindersRepository {

    fun getReminderStream(id: Int): Flow<Reminder>

    fun getRemindersFromUser(userId: Int): Flow<List<Reminder>>

    suspend fun insertReminder(reminder: Reminder)

    suspend fun updateReminder(reminder: Reminder)

    suspend fun deleteReminder(reminder: Reminder)

}