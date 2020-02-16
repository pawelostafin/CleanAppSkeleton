package com.example.cleanskeleton.presentation.second.model

import com.example.domain.Note
import javax.inject.Inject

class NoteToNoteDetailsMapper @Inject constructor() {

    fun map(note: Note): NoteDetails {
        return NoteDetails(
            title = note.title,
            message = note.message,
            formattedTime = note.dateTime.toLocalTime().toString(),
            formattedDate = note.dateTime.toLocalDate().toString()
        )
    }

    fun map(notes: List<Note>): List<NoteDetails> {
        return notes.map { this.map(it) }
    }

}