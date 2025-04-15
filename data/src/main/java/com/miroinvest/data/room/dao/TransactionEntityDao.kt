package com.miroinvest.data.room.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.miroinvest.data.models.TransactionEntity

@Dao
interface TransactionEntityDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertTransaction(transaction: TransactionEntity)

    @Query("SELECT * FROM TransactionEntity where id = :id")
    suspend fun getSingleTransaction(id: String): TransactionEntity

    @Query("SELECT * FROM TransactionEntity")
    suspend fun getTransactions(): List<TransactionEntity>

    @Delete
    suspend fun deleteTransaction(plan: TransactionEntity)
}