package com.example.cleanskeleton.presentation.main

import android.util.Log
import androidx.lifecycle.ViewModel
import com.example.domain.Note
import com.example.usecases.AddNoteUseCase
import com.example.usecases.DeleteAllNotesUseCase
import com.example.usecases.GetAllNotesUseCase
import com.jakewharton.rxrelay2.BehaviorRelay
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.rxkotlin.addTo
import io.reactivex.rxkotlin.subscribeBy
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class MainViewModel @Inject constructor(
    private val addNoteUseCase: AddNoteUseCase,
    private val deleteAllNotesUseCase: DeleteAllNotesUseCase,
    private val getAllNotesUseCase: GetAllNotesUseCase,
    private val noteToNoteItemMapper: NoteToNoteItemMapper
) : ViewModel() {

    private val noteItemsRelay: BehaviorRelay<List<NoteItem>> = BehaviorRelay.create()
    val noteItemsObs: Observable<List<NoteItem>> = noteItemsRelay

    private val disposables = CompositeDisposable()

    private var counter = 0

    fun onInitialized() {
        observeAllNotes()
    }

    private fun observeAllNotes() {
        getAllNotesUseCase.execute()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeBy(
                onNext = ::handleGetAllNotesResult,
                onError = {}
            )
            .addTo(disposables)
    }

    private fun handleGetAllNotesResult(result: GetAllNotesUseCase.Result) {
        when (result) {
            is GetAllNotesUseCase.Result.Success -> {
                val noteItems = noteToNoteItemMapper.map(result.notes)
                noteItemsRelay.accept(noteItems)
            }
            is GetAllNotesUseCase.Result.Loading -> Log.d("LOGGER GET ALL", "Loading")
            is GetAllNotesUseCase.Result.Failure -> Log.e("LOGGER GET ALL", "ERROR")
        }
    }

    fun addNoteButtonClicked() {
        addNoteUseCase
            .execute(Note(title = "title $counter", message = "message ${counter++}"))
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeBy(
                onNext = ::handleAddNoteResult,
                onError = {}
            )
            .addTo(disposables)
    }

    private fun handleAddNoteResult(result: AddNoteUseCase.Result) {
        when (result) {
            is AddNoteUseCase.Result.Success -> Log.d("LOGGER ADD", "Success")
            is AddNoteUseCase.Result.Loading -> Log.d("LOGGER ADD", "Loading")
            is AddNoteUseCase.Result.Failure -> Log.e("LOGGER ADD", "ERROR")
        }
    }

    fun deleteButtonClicked() {
        deleteAllNotesUseCase.execute()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeBy(
                onNext = ::handleDeleteAllNotesResult,
                onError = {}
            )
            .addTo(disposables)
    }

    private fun handleDeleteAllNotesResult(result: DeleteAllNotesUseCase.Result) {
        when (result) {
            is DeleteAllNotesUseCase.Result.Success -> Log.d("LOGGER DELETE ALL", "Success")
            is DeleteAllNotesUseCase.Result.Loading -> Log.d("LOGGER DELETE ALL", "Loading")
            is DeleteAllNotesUseCase.Result.Failure -> Log.e("LOGGER DELETE ALL", "ERROR")
        }
    }


}