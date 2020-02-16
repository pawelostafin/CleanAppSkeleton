package com.example.mainscreen.model

import com.example.domain.Note
import javax.inject.Inject

class NoteToNoteItemMapper @Inject constructor() {

    fun map(note: Note): NoteItem {
        return NoteItem(
            id = note.id,
            title = note.title,
            message = note.message,
            formattedDate = note.dateTime.toLocalDate().toString(),
            formattedTime = note.dateTime.toLocalTime().toString()
        )
    }

    fun map(notes: List<Note>): List<NoteItem> {
        return notes.map { this.map(it) }
    }

}
