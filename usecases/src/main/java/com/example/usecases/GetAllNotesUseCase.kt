package com.example.usecases

import com.example.data.NoteRepository

class GetAllNotesUseCase(private val noteRepository: NoteRepository) {

    fun execute() = noteRepository.getAll()

}