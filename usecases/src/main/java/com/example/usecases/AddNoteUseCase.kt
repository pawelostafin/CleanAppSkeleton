package com.example.usecases

import com.example.data.NoteRepository
import com.example.domain.Note
import com.example.usecases.AddNoteUseCase.Result.*
import io.reactivex.Observable
import javax.inject.Inject

class AddNoteUseCase @Inject constructor(private val noteRepository: NoteRepository) {

    private fun execute(note: Note): Observable<Result> =
        noteRepository.add(note)
            .toObservable()
            .map { Success as Result }
            .startWith(Loading)
            .onErrorReturn { Failure(it) }

    sealed class Result {
        object Success : Result()
        object Loading : Result()
        data class Failure(val throwable: Throwable) : Result()
    }

}

