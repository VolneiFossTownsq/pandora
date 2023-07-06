package io.townsq.pandora.utils

import java.text.SimpleDateFormat
import java.util.Date

class DateFormat {
    fun formatDate(epochTime: String): String {
        val date = Date(epochTime.toLong())
        val simpleDateFormat = SimpleDateFormat("dd/MM/yyyy HH:mm:ss")
        return simpleDateFormat.format(date)
    }
}
