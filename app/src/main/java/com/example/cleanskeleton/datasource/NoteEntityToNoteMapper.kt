package com.example.cleanskeleton.datasource

import com.example.cleanskeleton.framework.database.entities.NoteEntity
import com.example.domain.Note
import javax.inject.Inject

class NoteEntityToNoteMapper @Inject constructor() {

    fun map(noteEntity: NoteEntity): Note {
        return Note(
            title = noteEntity.title,
            message = noteEntity.message
        )
    }

    fun map(noteEntities: List<NoteEntity>): List<Note> {
        return noteEntities.map { this.map(it) }
    }

}