package com.example.cleanskeleton.presentation.main

import com.example.domain.Note
import javax.inject.Inject

class NoteToNoteItemMapper @Inject constructor() {

    fun map(note: Note): NoteItem {
        return NoteItem(
            title = note.title,
            message = note.message
        )
    }

    fun map(notes: List<Note>): List<NoteItem> {
        return notes.map { this.map(it) }
    }

}
