package com.example.usecases

import com.example.data.NoteRepository
import com.example.domain.Note
import com.example.usecases.GetAllNotesUseCase.Result.*
import io.reactivex.Observable
import javax.inject.Inject

class GetAllNotesUseCase @Inject constructor(private val noteRepository: NoteRepository) {

    fun execute(): Observable<Result> =
        noteRepository.getAll()
            .toObservable()
            .map { Success(it) as Result }
            .startWith(Loading)
            .onErrorReturn { Failure(it) }

    sealed class Result {
        data class Success(val notes: List<Note>) : Result()
        object Loading : Result()
        data class Failure(val throwable: Throwable) : Result()
    }

}