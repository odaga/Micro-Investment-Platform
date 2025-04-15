package com.miroinvest.data.util

import java.text.DecimalFormat
import java.time.LocalDateTime
import java.time.format.DateTimeFormatterBuilder
import java.util.Locale

fun Double.formatDomainCurrency(): String {
    val format = DecimalFormat("#,###")
    format.isDecimalSeparatorAlwaysShown = false
    return "UGX ${format.format(this)}"
}

fun String.formatDateTime(): String {
    val localDateTime = LocalDateTime.parse(this)
    val dateFormatter = DateTimeFormatterBuilder()
        .parseCaseInsensitive()
        .appendPattern("MMM d, yyyy h:mm a")
        .toFormatter(Locale.ENGLISH)

    return localDateTime.format(dateFormatter)
}