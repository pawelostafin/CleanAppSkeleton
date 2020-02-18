package com.example.framework.datasource

import com.example.framework.database.entities.NoteEntity
import com.example.common.extension.toLocalDateTime
import com.example.domain.Note
import javax.inject.Inject

class NoteEntityToNoteMapper @Inject constructor() {

    fun map(noteEntity: NoteEntity): Note {
        return Note(
            id = noteEntity.id,
            dateTime = noteEntity.timestamp.toLocalDateTime(),
            title = noteEntity.title,
            message = noteEntity.message
        )
    }

    fun map(noteEntities: List<NoteEntity>): List<Note> {
        return noteEntities.map { this.map(it) }
    }

}