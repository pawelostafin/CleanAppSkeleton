package com.example.domain

import org.threeten.bp.LocalDateTime

data class Note(
    val dateTime: LocalDateTime,
    val title: String,
    val message: String,
    val id: Long?
)