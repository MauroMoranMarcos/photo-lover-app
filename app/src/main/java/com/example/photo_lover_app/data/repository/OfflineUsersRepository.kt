package com.example.photo_lover_app.data.repository

import com.example.photo_lover_app.data.db.dao.UserDao
import com.example.photo_lover_app.data.db.entities.User
import kotlinx.coroutines.flow.Flow

class OfflineUsersRepository(private val userDao: UserDao) : UsersRepository {
    override fun getUserStream(id: Int): Flow<User> {
        return userDao.getUser(id)
    }

    override suspend fun insertUser(user: User) {
        return userDao.insert(user)
    }

    override suspend fun updateUser(user: User) {
        return userDao.update(user)
    }

    override suspend fun deleteUser(user: User) {
        return deleteUser(user)
    }
}