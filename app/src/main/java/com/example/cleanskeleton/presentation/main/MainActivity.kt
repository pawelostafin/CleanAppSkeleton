package com.example.cleanskeleton.presentation.main

import android.annotation.SuppressLint
import android.app.Activity
import android.content.Intent
import androidx.appcompat.widget.AppCompatTextView
import com.example.cleanskeleton.R
import com.example.common.presentation.base.BaseMvvmActivity
import com.example.cleanskeleton.presentation.main.model.NoteItem
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
    }

    @SuppressLint("SetTextI18n")
    private fun fillLinearLayout(noteItems: List<NoteItem>) {
        linearLayout.removeAllViews()
        noteItems.forEach { noteItem ->
            val itemView = AppCompatTextView(this).apply {
                text = "${noteItem.title} ${noteItem.message} ${noteItem.formattedTime}"

                setOnClickListener { viewModel.noteItemClicked(noteItem) }
            }
            linearLayout.addView(itemView)
        }
    }

    companion object {
        fun start(callerActivity: Activity) {
            val intent = Intent(callerActivity, MainActivity::class.java)
            callerActivity.startActivity(intent)
        }
    }

}
