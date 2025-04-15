package com.miroinvest.data.domain.repositories

import com.miroinvest.data.models.InvestmentEntity
import com.miroinvest.data.models.PlanEntity
import com.miroinvest.data.models.TransactionEntity
import com.miroinvest.data.models.User
import kotlinx.coroutines.flow.Flow

interface PreferenceRepository {

    suspend fun isDatabaseSeeded(): Flow<Boolean>

    suspend fun saveUserToDatastore(user: User)

    fun getDataStoreUser(): Flow<User>

    suspend fun clearUser()

    suspend fun getLocalPlans(): List<PlanEntity>

    suspend fun getSinglePlan(planId: String): PlanEntity?

    suspend fun getTransactions(): List<TransactionEntity>

    suspend fun getSingleTransaction(transactionId: String): TransactionEntity?

    suspend fun getInvestments(): List<InvestmentEntity>

}