package com.example.photo_lover_app.data.repository

import com.example.photo_lover_app.data.db.dao.ReminderDao
import com.example.photo_lover_app.data.db.entities.Reminder
import kotlinx.coroutines.flow.Flow

class OfflineRemindersRepository(private val reminderDao: ReminderDao) : RemindersRepository {
    override fun getReminderStream(id: Int): Flow<Reminder> {
        return reminderDao.getReminder(id)
    }

    override fun getRemindersFromUser(userId: Int): Flow<List<Reminder>> {
        return reminderDao.getRemindersFromUser(userId)
    }

    override suspend fun insertReminder(reminder: Reminder) {
        return reminderDao.insert(reminder)
    }

    override suspend fun updateReminder(reminder: Reminder) {
        return reminderDao.update(reminder)
    }

    override suspend fun deleteReminder(reminder: Reminder) {
        return reminderDao.delete(reminder)
    }
}