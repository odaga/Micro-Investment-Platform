package com.miroinvest.data.room.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.miroinvest.data.models.PlanEntity

@Dao
interface PlanDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertPlan(plan: PlanEntity)

    @Query("SELECT * FROM PlanEntity where id = :id")
    suspend fun getSinglePlan(id: String): PlanEntity

    @Query("SELECT * FROM PlanEntity")
    suspend fun getPlans(): List<PlanEntity>

    @Delete
    suspend fun deletePlan(plan: PlanEntity)
}