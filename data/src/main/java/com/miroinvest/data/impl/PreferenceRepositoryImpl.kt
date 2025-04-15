package com.miroinvest.data.impl

import android.content.SharedPreferences
import androidx.core.content.edit
import com.miroinvest.data.domain.repositories.PreferenceRepository
import com.miroinvest.data.models.PlanEntity
import com.miroinvest.data.models.TransactionEntity
import com.miroinvest.data.models.User
import com.miroinvest.data.room.dao.PlanDao
import com.miroinvest.data.room.dao.TransactionEntityDao
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject


class PreferenceRepositoryImpl @Inject constructor(
    private val encryptedPreferences: SharedPreferences,
    private val planDao: PlanDao,
    private val transactionDao: TransactionEntityDao
) : PreferenceRepository {

     override suspend fun isDatabaseSeeded(): Flow<Boolean> = flow {
        emit(encryptedPreferences.getBoolean("IS_DB_SEEDED", false))
    }


    override suspend fun saveUserToDatastore(user: User) {
        encryptedPreferences.edit().apply() {
            putString("ID", user.id)
            putString("EMAIL", user.email)
            putString("FIRST_NAME", user.firstName)
            putString("LAST_NAME", user.lastName)
            apply()
        }
    }

    override fun getDataStoreUser(): Flow<User> = flow {
        emit(
            User(
                id = encryptedPreferences.getString("ID", "") ?: "",
                email = encryptedPreferences.getString("EMAIL", "") ?: "",
                firstName = encryptedPreferences.getString("FIRST_NAME", "") ?: "",
                lastName = encryptedPreferences.getString("LAST_NAME", "") ?: ""
            )
        )
    }


    override suspend fun clearUser() {
        encryptedPreferences.edit() { clear() }
    }

    override suspend fun getLocalPlans(): List<PlanEntity> {
        return planDao.getPlans()
    }

    override suspend fun getSinglePlan(planId: String): PlanEntity {
        return planDao.getSinglePlan(planId)
    }

    override suspend fun getTransactions(): List<TransactionEntity> {
        return transactionDao.getTransactions()
    }

    override suspend fun getSingleTransaction(transactionId: String): TransactionEntity? {
        return transactionDao.getSingleTransaction(transactionId)
    }


}