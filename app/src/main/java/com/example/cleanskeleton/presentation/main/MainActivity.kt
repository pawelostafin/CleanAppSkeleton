package com.example.cleanskeleton.presentation.main

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.widget.AppCompatTextView
import androidx.lifecycle.ViewModelProvider
import com.example.cleanskeleton.R
import com.example.cleanskeleton.framework.CleanAppSkeletonViewModelFactory
import dagger.android.support.DaggerAppCompatActivity
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.rxkotlin.addTo
import kotlinx.android.synthetic.main.activity_main.*
import javax.inject.Inject

class MainActivity : DaggerAppCompatActivity() {

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    private val disposables = CompositeDisposable()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val viewModel = ViewModelProvider(this, viewModelFactory).get(MainViewModel::class.java)

        addNoteButton.setOnClickListener {
            viewModel.addNoteButtonClicked()
        }

        deleteButton.setOnClickListener {
            viewModel.deleteButtonClicked()
        }

        viewModel.noteItemsObs
            .subscribe(::fillLinearLayout)
            .addTo(disposables)

        viewModel.onInitialized()
    }

    @SuppressLint("SetTextI18n")
    private fun fillLinearLayout(noteItems: List<NoteItem>) {
        linearLayout.removeAllViews()
        noteItems.forEach {
            val itemView = AppCompatTextView(this).apply {
                text = "${it.title} ${it.message}"
            }
            linearLayout.addView(itemView)
        }
    }

}
