package com.example.framework.datasource

import com.example.framework.database.entities.NoteEntity
import com.example.common.extension.millis
import com.example.domain.Note
import javax.inject.Inject


class NoteToNoteEntityMapper @Inject constructor() {

    fun map(note: Note): NoteEntity {
        return NoteEntity(
            title = note.title,
            message = note.message,
            timestamp = note.dateTime.millis,
            id = note.id
        )
    }

    fun map(notes: List<Note>): List<NoteEntity> {
        return notes.map { this.map(it) }
    }

}
