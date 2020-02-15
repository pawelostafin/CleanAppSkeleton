package com.example.usecases

import com.example.data.NoteRepository
import com.example.usecases.DeleteAllNotesUseCase.Result.*
import io.reactivex.Observable
import javax.inject.Inject

class DeleteAllNotesUseCase @Inject constructor(private val noteRepository: NoteRepository) {

    fun execute(): Observable<Result> =
        noteRepository.deleteAll()
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
