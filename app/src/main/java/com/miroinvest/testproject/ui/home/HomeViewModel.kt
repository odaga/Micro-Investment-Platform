package com.miroinvest.testproject.ui.home

import androidx.lifecycle.ViewModel
import com.miroinvest.data.domain.repositories.PreferenceRepository
import com.miroinvest.data.models.PlanEntity
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val preferenceRepository: PreferenceRepository
) : ViewModel() {

    suspend fun getInvestmentPlans(): List<PlanEntity> {
        return preferenceRepository.getLocalPlans()
    }
}