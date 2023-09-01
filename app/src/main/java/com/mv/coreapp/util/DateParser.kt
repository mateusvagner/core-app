package com.mv.coreapp.util

import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

/**
 *
 * https://docs.oracle.com/javase/7/docs/api/java/text/SimpleDateFormat.html
 *
 * */
object DateParser {
    private const val ISO_8601_FORMAT = "yyyy-MM-dd'T'HH:mm:ss.SSSXXX"

    fun parseDate(date: String): Date? {
        val format = SimpleDateFormat(ISO_8601_FORMAT, Locale.getDefault())

        return format.parse(date)
    }

    fun formatDate(date: Date): String {
        val format = SimpleDateFormat(ISO_8601_FORMAT, Locale.getDefault())

        return format.format(date)
    }
}
