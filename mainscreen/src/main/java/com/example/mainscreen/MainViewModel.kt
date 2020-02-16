package com.example.mainscreen

import com.example.common.presentation.base.BaseViewModel
import com.example.common.extension.toLocalDateTime
import com.example.common.navigator.ScreenNavigator
import com.example.domain.Note
import com.example.mainscreen.model.NoteItem
import com.example.mainscreen.model.NoteToNoteItemMapper
import com.example.usecases.AddNoteUseCase
import com.example.usecases.DeleteAllNotesUseCase
import com.example.usecases.GetAllNotesUseCase
import com.jakewharton.rxrelay2.BehaviorRelay
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.rxkotlin.addTo
import io.reactivex.rxkotlin.subscribeBy
import io.reactivex.schedulers.Schedulers
import timber.log.Timber
import javax.inject.Inject

class MainViewModel @Inject constructor(
    private val addNoteUseCase: AddNoteUseCase,
    private val deleteAllNotesUseCase: DeleteAllNotesUseCase,
    private val getAllNotesUseCase: GetAllNotesUseCase,
    private val noteToNoteItemMapper: NoteToNoteItemMapper
) : BaseViewModel() {

    private val noteItemsRelay: BehaviorRelay<List<NoteItem>> = BehaviorRelay.create()
    val noteItemsObs: Observable<List<NoteItem>> = noteItemsRelay

    private var counter = 0

    override fun onViewInitialized() {
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
                Timber.d("LOGGER Success GET ALL")
                val noteItems = noteToNoteItemMapper.map(result.notes)
                noteItemsRelay.accept(noteItems)
            }
            is GetAllNotesUseCase.Result.Loading -> Timber.d("LOGGER Loading GET ALL")
            is GetAllNotesUseCase.Result.Failure -> Timber.e("LOGGER ${result.throwable}")
        }
    }

    fun addNoteButtonClicked() {
        addNoteUseCase
            .execute(
                Note(
                    title = "title $counter",
                    message = "message ${counter++}",
                    dateTime = System.currentTimeMillis().toLocalDateTime(),
                    id = null
                )
            )
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
            is AddNoteUseCase.Result.Success -> Timber.d("LOGGER Success ADD")
            is AddNoteUseCase.Result.Loading -> Timber.d("LOGGER Loading ADD")
            is AddNoteUseCase.Result.Failure -> Timber.e("LOGGER ${result.throwable}")
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
            is DeleteAllNotesUseCase.Result.Success -> Timber.d("LOGGER Success DELETE")
            is DeleteAllNotesUseCase.Result.Loading -> Timber.d("LOGGER Loading DELETE")
            is DeleteAllNotesUseCase.Result.Failure -> Timber.e("LOGGER ${result.throwable}")
        }
    }

    fun noteItemClicked(noteItem: NoteItem) {
        screenNavigator.navigateToSecondScreen(noteItem.id!!)
    }

}