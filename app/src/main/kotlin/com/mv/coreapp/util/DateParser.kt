package com.mv.coreapp.util

import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale
import java.util.TimeZone

/**
 *
 * https://docs.oracle.com/javase/7/docs/api/java/text/SimpleDateFormat.html
 *
 * */
object DateParser {
    private const val ISO_8601_FORMAT = "yyyy-MM-dd'T'HH:mm:ss.SSSXXX"

    fun parseDateIsoFormat(date: String): Date? {
        val format = SimpleDateFormat(ISO_8601_FORMAT, Locale.getDefault())

        return format.parse(date)
    }

    fun formatDateIsoFormat(date: Date): String {
        val format = SimpleDateFormat(ISO_8601_FORMAT, Locale.getDefault())

        return format.format(date)
    }

    fun parteDateCustomFormat(date: String, format: String): Date? {
        val format = SimpleDateFormat(format, Locale.getDefault()).apply {
            timeZone = TimeZone.getTimeZone("UTC")
        }

        return format.parse(date)
    }

    fun formatDateCustomFormat(date: Date, format: String): String {
        val format = SimpleDateFormat(format, Locale.getDefault()).apply {
            timeZone = TimeZone.getTimeZone("UTC")
        }

        return format.format(date)
    }
}
