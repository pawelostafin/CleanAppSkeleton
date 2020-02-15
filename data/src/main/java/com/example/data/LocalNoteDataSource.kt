package com.example.data

import com.example.domain.Note
import io.reactivex.Completable
import io.reactivex.Flowable
import io.reactivex.Single

interface LocalNoteDataSource {

    fun add(note: Note): Single<Long>

    fun getAll(): Flowable<List<Note>>

    fun deleteAll(): Single<Int>

}
