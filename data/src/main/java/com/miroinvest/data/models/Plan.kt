package com.miroinvest.data.models

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class PlanEntity(
    @PrimaryKey(autoGenerate = false)
    val id: String,
    val name: String,
    val returnRate: String,
    val lockPeriod: String,
    val minAmount: String,
    val maxAmount: String
)
