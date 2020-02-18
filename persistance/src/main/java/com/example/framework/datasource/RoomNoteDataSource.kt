package com.example.framework.datasource

import com.example.framework.database.dao.NoteEntityDAO
import com.example.data.LocalNoteDataSource
import com.example.domain.Note
import io.reactivex.Observable
import io.reactivex.Single
import javax.inject.Inject

class RoomNoteDataSource @Inject constructor(
    private val noteEntityDAO: NoteEntityDAO,
    private val noteToNoteEntityMapper: NoteToNoteEntityMapper,
    private val noteEntityToNoteMapper: NoteEntityToNoteMapper
) : LocalNoteDataSource {

    override fun add(note: Note): Single<Long> {
        return Single.fromCallable {
            val noteEntity = noteToNoteEntityMapper.map(note)
            noteEntityDAO.insert(noteEntity)
        }
    }

    override fun getById(noteId: Long): Observable<Note> {
        return noteEntityDAO.getById(noteId).map { noteEntityToNoteMapper.map(it) }
    }

    override fun getAll(): Observable<List<Note>> {
        return noteEntityDAO.getAll().map { noteEntityToNoteMapper.map(it) }
    }

    override fun deleteAll(): Single<Int> {
        return Single.fromCallable {
            noteEntityDAO.deleteAll()
        }
    }

}