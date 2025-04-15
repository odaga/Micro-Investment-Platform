package com.miroinvest.testproject.core.utils

import com.miroinvest.data.models.PlanEntity

object SampleData {
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

}