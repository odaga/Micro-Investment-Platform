package com.miroinvest.data.util

import com.miroinvest.data.models.InvestmentEntity
import com.miroinvest.data.models.PlanEntity

object LocalConstants {
    const val APP_DATABASE_NAME = "MICRO_VEST_DB"
    val dummyPlans = arrayListOf(

        PlanEntity(
            id = "save_daily",
            name = "Save Daily",
            returnRate = "1.2%",
            lockPeriod = "7 days",
            minAmount = "100",
            maxAmount = "500"
        ),
        PlanEntity(
            id = "grow_fast",
            name = "GrowFast",
            returnRate = "1.5%",
            lockPeriod = "14 days",
            minAmount = "250",
            maxAmount = "1000"
        ),
        PlanEntity(
            id = "premium_growth",
            name = "Premium Growth",
            returnRate = "2%",
            lockPeriod = "30 days",
            minAmount = "500",
            maxAmount = "10000"
        ),
        PlanEntity(
            id = "steady_income",
            name = "steady Income",
            returnRate = "1%",
            lockPeriod = "5 days",
            minAmount = "50",
            maxAmount = "50000"
        ),
        PlanEntity(
            id = "wealth_Builder",
            name = "Wealth Builder",
            returnRate = "2.5%",
            lockPeriod = "60 days",
            minAmount = "1000",
            maxAmount = "50000"
        )
    )

    val dummyInvestments = arrayListOf(
        InvestmentEntity(
            id = "inv_001",
            planType = "Starter Plan",
            name = "Starter Savings",
            returnRate = "5%",
            lockPeriod = "3 months",
            initialAmount = "200",
            currentAmount = "210",
            startDate = "2025-01-01",
            status = "Active",
            endDate = "2025-04-01"
        ),
        InvestmentEntity(
            id = "inv_002",
            planType = "Silver Plan",
            name = "Silver Investment",
            returnRate = "7%",
            lockPeriod = "6 months",
            initialAmount = "1500",
            currentAmount = "1605",
            startDate = "2024-12-15",
            status = "Active",
            endDate = "2025-06-15"
        ),
        InvestmentEntity(
            id = "inv_003",
            planType = "Gold Plan",
            name = "Gold Vault",
            returnRate = "10%",
            lockPeriod = "12 months",
            initialAmount = "5000",
            currentAmount = "5500",
            startDate = "2024-08-01",
            status = "Active",
            endDate = "2025-08-01"
        ),
        InvestmentEntity(
            id = "inv_004",
            planType = "Platinum Plan",
            name = "Platinum Dream",
            returnRate = "15%",
            lockPeriod = "24 months",
            initialAmount = "25000",
            currentAmount = "28750",
            startDate = "2023-04-10",
            status = "Matured",
            endDate = "2025-04-10"
        )
    )

}