package com.example.photo_lover_app.data.db.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "users")
data class User (

    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val name: String,
    val profilePicUri: String

)