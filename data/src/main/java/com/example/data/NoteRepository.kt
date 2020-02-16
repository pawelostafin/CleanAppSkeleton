package com.example.data

import com.example.domain.Note
import io.reactivex.Observable
import io.reactivex.Single
import javax.inject.Inject

class NoteRepository @Inject constructor(private var localNoteDataSource: LocalNoteDataSource) {

    fun add(note: Note): Single<Long> = localNoteDataSource.add(note)

    fun getById(noteId: Long): Observable<Note> = localNoteDataSource.getById(noteId)

    fun getAll(): Observable<List<Note>> = localNoteDataSource.getAll()

    fun deleteAll(): Single<Int> = localNoteDataSource.deleteAll()

}