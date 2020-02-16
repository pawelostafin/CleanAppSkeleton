package com.example.cleanskeleton.presentation.main

import android.annotation.SuppressLint
import androidx.appcompat.widget.AppCompatTextView
import com.example.cleanskeleton.R
import com.example.cleanskeleton.presentation.base.BaseMvvmActivity
import com.example.cleanskeleton.presentation.main.navigation.Destination
import com.example.cleanskeleton.presentation.second.SecondActivity
import io.reactivex.rxkotlin.addTo
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : BaseMvvmActivity<MainViewModel>() {

    override val layoutResId: Int
        get() = R.layout.activity_main

    override val viewModelClass: Class<MainViewModel>
        get() = MainViewModel::class.java

    override fun bindUI() {
        super.bindUI()

        addNoteButton.setOnClickListener { viewModel.addNoteButtonClicked() }
        deleteButton.setOnClickListener { viewModel.deleteButtonClicked() }
    }

    override fun observeViewModel() {
        super.observeViewModel()

        viewModel.noteItemsObs
            .subscribe(::fillLinearLayout)
            .addTo(disposables)

        viewModel.navigationObs
            .subscribe(::handleNavigation)
            .addTo(disposables)
    }

    @SuppressLint("SetTextI18n")
    private fun fillLinearLayout(noteItems: List<NoteItem>) {
        linearLayout.removeAllViews()
        noteItems.forEach { noteItem ->
            val itemView = AppCompatTextView(this).apply {
                text = "${noteItem.title} ${noteItem.message}"

                setOnClickListener { viewModel.noteItemClicked(noteItem) }
            }
            linearLayout.addView(itemView)
        }
    }

    private fun handleNavigation(destination: Destination) {
        when (destination) {
            is Destination.SecondActivity ->
                SecondActivity.start(callerActivity = this, noteId = destination.noteId)

            is Destination.Back -> finish()
        }
    }

}
