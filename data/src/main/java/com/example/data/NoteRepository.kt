package com.example.data

import com.example.domain.Note
import io.reactivex.Flowable
import io.reactivex.Single

class NoteRepository(private var localNoteDataSource: LocalNoteDataSource) {

    fun add(note: Note): Single<Long> = localNoteDataSource.add(note)

    fun getAll(): Flowable<List<Note>> = localNoteDataSource.getAll()

}