package com.miroinvest.data.impl

import android.content.SharedPreferences
import com.miroinvest.data.domain.repositories.PreferenceRepository
import com.miroinvest.data.room.dao.PlanDao
import com.miroinvest
.data.room.dao.TransactionEntityDao
import com.miroinvest.data.util.LocalConstants
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.launch
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class SeedingRepository @Inject constructor(
    private val planDao: PlanDao,
    private val encryptedPreferences: SharedPreferences,
    private val preferenceRepository: PreferenceRepository
) {

    suspend fun seedDatabase() {
        val isSeeded = preferenceRepository.isDatabaseSeeded().first()
        if (!isSeeded) {
            CoroutineScope(Dispatchers.IO).launch {
                LocalConstants.dummyPlans.forEach {
                    planDao.insertPlan(it)
                }
                encryptedPreferences.edit().apply() {
                    putBoolean("IS_DB_SEEDED", true)
                    apply()
                }
            }
        }
    }

}