package com.miroinvest.data.room

import androidx.room.TypeConverter

@TypeConverter
fun stringToArrayList(string: String?): ArrayList<String>? {
    when {
        string.isNullOrEmpty() -> {
            return null
        }

        string.contains(",").not() -> {
            val list = ArrayList<String>()
            list.add(string)
            return list
        }

        else -> {
            return string.split(",".toRegex())
                .dropLastWhile { it.isEmpty() } as ArrayList<String>
        }
    }
}