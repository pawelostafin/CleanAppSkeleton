package com.example.common.extension

import org.threeten.bp.Instant
import org.threeten.bp.LocalDateTime
import org.threeten.bp.ZoneId

private val defaultZoneId = ZoneId.systemDefault()

fun Long.toLocalDateTime(): LocalDateTime {
    return LocalDateTime.ofInstant(
        Instant.ofEpochMilli(this),
        defaultZoneId
    )
}

val LocalDateTime.millis
    get() = this.atZone(defaultZoneId).toInstant().toEpochMilli()