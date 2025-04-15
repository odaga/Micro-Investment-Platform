package com.miroinvest.testproject.ui.portFolio

import androidx.lifecycle.ViewModel
import com.miroinvest.data.domain.repositories.PreferenceRepository
import com.miroinvest.data.models.InvestmentEntity
import dagger.hilt.android.AndroidEntryPoint
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class PortFolioViewModel @Inject constructor(
    private val preferenceRepository: PreferenceRepository
) : ViewModel() {
    suspend fun getInvestments(): List<InvestmentEntity> = preferenceRepository.getInvestments()

}