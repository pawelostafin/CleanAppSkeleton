package com.example.usecases

import com.example.data.NoteRepository
import com.example.domain.Note
import com.example.usecases.GetNoteByIdUseCase.Result.*
import io.reactivex.Observable
import javax.inject.Inject

class GetNoteByIdUseCase @Inject constructor(
    private val noteRepository: NoteRepository
) {

    fun execute(noteId: Long): Observable<Result> =
        noteRepository.getById(noteId)
            .map { Success(it) as Result }
            .startWith(Loading)
            .onErrorReturn { Failure(it) }

    sealed class Result {
        data class Success(val note: Note) : Result()
        object Loading : Result()
        data class Failure(val throwable: Throwable) : Result()
    }

}