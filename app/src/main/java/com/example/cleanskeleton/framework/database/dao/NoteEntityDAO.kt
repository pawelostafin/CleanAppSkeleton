package com.example.cleanskeleton.framework.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.cleanskeleton.framework.database.entities.NoteEntity
import io.reactivex.Flowable
import io.reactivex.Observable
import io.reactivex.Single

@Dao
interface NoteEntityDAO {

    @Insert
    fun insert(entry: NoteEntity): Long

    @Query("SELECT * FROM note_entity WHERE id=:noteId")
    fun getById(noteId: Long): Observable<NoteEntity>

    @Query("SELECT * FROM note_entity")
    fun getAll(): Observable<List<NoteEntity>>

    @Query("DELETE FROM note_entity")
    fun deleteAll(): Int

}