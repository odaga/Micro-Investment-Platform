package com.miroinvest.data.models

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class TransactionEntity(
    @PrimaryKey(autoGenerate = false)
    val id: String,
    val type: String,
    val amount: String,
    val date: String
)



