package com.example.cleanskeleton.framework.datasource

import com.example.cleanskeleton.framework.database.entities.NoteEntity
import com.example.cleanskeleton.util.millis
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
