package com.example.photo_lover_app.data.db.entities

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey
import java.util.Date

@Entity(
    tableName = "images",
    foreignKeys = [ForeignKey(
        entity = User::class,
        parentColumns = ["id"],
        childColumns = ["userId"],
        onDelete = ForeignKey.NO_ACTION
    )])
data class Image (

    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val imageUri: String,
    val description: String,
    val date: Date,
    val userId: Int

)