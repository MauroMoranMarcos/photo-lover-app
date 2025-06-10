package com.example.photo_lover_app.data.db.entities

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey

@Entity(
    tableName = "reminders",
    foreignKeys = [ForeignKey(
        entity = User::class,
        parentColumns = ["id"],
        childColumns = ["userId"],
        onDelete = ForeignKey.NO_ACTION
    )])
data class Reminder(

    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val date: String,
    val description: String,
    val imageUri: String,
    val userId: Int

)