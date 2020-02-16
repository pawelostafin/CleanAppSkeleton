package com.example.secondscreen

import com.example.common.presentation.base.BaseViewModel
import com.example.secondscreen.model.NoteDetails
import com.example.secondscreen.model.NoteToNoteDetailsMapper
import com.example.usecases.GetNoteByIdUseCase
import com.jakewharton.rxrelay2.BehaviorRelay
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.rxkotlin.addTo
import io.reactivex.rxkotlin.subscribeBy
import io.reactivex.schedulers.Schedulers
import timber.log.Timber
import javax.inject.Inject

class SecondViewModel @Inject constructor(
    private val noteId: Long,
    private val getNoteByIdUseCase: GetNoteByIdUseCase,
    private val noteToNoteDetailsMapper: NoteToNoteDetailsMapper
) : BaseViewModel() {

    private val noteRelay: BehaviorRelay<NoteDetails> = BehaviorRelay.create()
    val noteObs: Observable<NoteDetails> = noteRelay

    override fun onViewInitialized() {
        getNoteByIdUseCase.execute(noteId)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeBy(
                onNext = ::handleGetByIdResult,
                onError = Timber::e
            )
            .addTo(disposables)
    }

    private fun handleGetByIdResult(result: GetNoteByIdUseCase.Result) {
        when (result) {
            is GetNoteByIdUseCase.Result.Success -> {
                val noteDetails = noteToNoteDetailsMapper.map(result.note)
                noteRelay.accept(noteDetails)
            }
            is GetNoteByIdUseCase.Result.Loading -> Timber.d("LOGGER LOADING")
            is GetNoteByIdUseCase.Result.Failure -> Timber.e("LOGGER ERROR ${result.throwable}")
        }
    }


}