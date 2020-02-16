package com.example.data

import com.example.domain.Note
import io.reactivex.Completable
import io.reactivex.Flowable
import io.reactivex.Observable
import io.reactivex.Single

interface LocalNoteDataSource {

    fun add(note: Note): Single<Long>

    fun getById(noteId: Long): Observable<Note>

    fun getAll(): Observable<List<Note>>

    fun deleteAll(): Single<Int>

}
