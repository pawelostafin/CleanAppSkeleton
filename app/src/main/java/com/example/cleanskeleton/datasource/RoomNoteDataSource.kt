package com.example.cleanskeleton.datasource

import com.example.cleanskeleton.framework.database.dao.NoteEntityDAO
import com.example.data.LocalNoteDataSource
import com.example.domain.Note
import io.reactivex.Flowable
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

    override fun getAll(): Flowable<List<Note>> {
        return noteEntityDAO.getAll().map { noteEntityToNoteMapper.map(it) }
    }

    override fun deleteAll(): Single<Int> {
        return Single.fromCallable {
            noteEntityDAO.deleteAll()
        }
    }

}