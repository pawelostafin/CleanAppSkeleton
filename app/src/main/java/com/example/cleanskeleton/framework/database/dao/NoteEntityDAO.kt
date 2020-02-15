package com.example.cleanskeleton.framework.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.cleanskeleton.framework.database.entities.NoteEntity
import io.reactivex.Flowable

@Dao
interface NoteEntityDAO {

    @Insert
    fun insert(entry: NoteEntity): Long

    @Query("SELECT * FROM note_entity")
    fun getAll(): Flowable<List<NoteEntity>>

}