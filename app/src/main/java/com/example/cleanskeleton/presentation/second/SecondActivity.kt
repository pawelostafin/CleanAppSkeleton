package com.example.cleanskeleton.presentation.second

import android.app.Activity
import android.content.Intent
import com.example.cleanskeleton.R
import com.example.cleanskeleton.presentation.base.BaseMvvmActivity

class SecondActivity : BaseMvvmActivity<SecondViewModel>() {

    override val layoutResId: Int
        get() = R.layout.activity_second

    override val viewModelClass: Class<SecondViewModel>
        get() = SecondViewModel::class.java

    override fun setupView() {
        super.setupView()
    }

    companion object {
        const val EXTRA_NOTE_ID = "EXTRA_NOTE_ID"

        fun start(callerActivity: Activity, noteId: Long) {
            val intent = Intent(callerActivity, SecondActivity::class.java).apply {
                putExtra(EXTRA_NOTE_ID, noteId)
            }
            callerActivity.startActivity(intent)
        }
    }

}
