package com.example.cleanskeleton.framework.database.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "note_entity")
data class NoteEntity(
    val title: String,
    val message: String,
    @PrimaryKey(autoGenerate = true)
    var id: Long? = null
)