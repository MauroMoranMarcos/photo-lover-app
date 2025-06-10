package com.example.photo_lover_app.data.repository

import com.example.photo_lover_app.data.db.entities.User
import kotlinx.coroutines.flow.Flow

interface UsersRepository {

    fun getUserStream(id: Int): Flow<User>

    suspend fun insertUser(user: User)

    suspend fun updateUser(user: User)

    suspend fun deleteUser(user: User)

}