package com.example.usecases

import com.example.data.NoteRepository
import com.example.domain.Note

class AddNoteUseCase(private val noteRepository: NoteRepository) {

    private fun execute(note: Note) = noteRepository.add(note)

}

