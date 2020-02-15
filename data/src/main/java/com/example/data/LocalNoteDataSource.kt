package com.example.data

import com.example.domain.Note

interface LocalNoteDataSource {

    fun add(note: Note): Long

    fun getAll(): List<Note>

}
