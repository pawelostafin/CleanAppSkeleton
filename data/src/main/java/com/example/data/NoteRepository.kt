package com.example.data

import com.example.domain.Note

class NoteRepository(private var localNoteDataSource: LocalNoteDataSource) {

    fun add(note: Note) = localNoteDataSource.add(note)

    fun getAll(): List<Note> = localNoteDataSource.getAll()

}