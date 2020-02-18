package com.example.framework.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.framework.database.dao.NoteEntityDAO
import com.example.framework.database.entities.NoteEntity


@Database(
    entities = [NoteEntity::class],
    version = 1,
    exportSchema = false
)
abstract class AppDatabase : RoomDatabase() {
    abstract fun noteEntityDAO(): NoteEntityDAO
}
