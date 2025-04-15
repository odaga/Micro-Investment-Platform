package com.miroinvest.data.room.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.miroinvest.data.models.InvestmentEntity
import com.miroinvest.data.models.PlanEntity

@Dao
interface InvestmentDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertInvestment(plan: InvestmentEntity)

    @Query("SELECT * FROM InvestmentEntity where id = :id")
    suspend fun getInvestmentById(id: String): InvestmentEntity

    @Query("SELECT * FROM InvestmentEntity")
    suspend fun getInvestments(): List<InvestmentEntity>

    @Delete
    suspend fun deleteInvestment(plan: InvestmentEntity)
}