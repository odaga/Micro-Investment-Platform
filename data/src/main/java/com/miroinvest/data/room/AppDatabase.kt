package com.miroinvest.data.room

import androidx.room.Database
import androidx.room.RoomDatabase
import com.miroinvest.data.models.InvestmentEntity
import com.miroinvest.data.models.PlanEntity
import com.miroinvest.data.models.TransactionEntity
import com.miroinvest.data.room.dao.InvestmentDao
import com.miroinvest.data.room.dao.PlanDao
import com.miroinvest.data.room.dao.TransactionEntityDao

@Database(
    entities = [
        PlanEntity::class,
        TransactionEntity::class,
        InvestmentEntity::class
    ],
    version = 1,
    exportSchema = false
)

abstract class AppDatabase : RoomDatabase() {
    abstract fun PlanDao(): PlanDao
    abstract fun transactionDao(): TransactionEntityDao
    abstract fun investmentDao(): InvestmentDao
}