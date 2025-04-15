package com.miroinvest.testproject.ui.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.recyclerview.widget.RecyclerView
import com.miroinvest.data.models.InvestmentEntity
import com.miroinvest.testproject.databinding.ActiveInvestmentLayoutBinding

class InvestmentsAdapter(
    private val investments: List<InvestmentEntity>,
    private val onItemClickListener: OnItemClickListener
) : RecyclerView.Adapter<InvestmentsAdapter.ViewHolder>() {

    inner class ViewHolder(binding: ActiveInvestmentLayoutBinding) :
        RecyclerView.ViewHolder(binding.root) {
        val investmentType = binding.investmentType
        val dateInvested = binding.investmentDate
        val withdrawButton = binding.withdrawButton
        val infoButton = binding.infoButton
        val initialAmount = binding.initialAmount
        val currentAmount = binding.currentAmount
        val returnRate = binding.returnRate
        val lockPeriod = binding.lockPeriod
        val status = binding.status
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            ActiveInvestmentLayoutBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }


    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        with(holder) {

            investmentType.text = investments[position].planType
            dateInvested.text = investments[position].startDate
            initialAmount.text = investments[position].initialAmount
            currentAmount.text = investments[position].currentAmount
            lockPeriod.text = investments[position].lockPeriod
            returnRate.text = investments[position].returnRate
            status.text = investments[position].status

            withdrawButton.setOnClickListener {
                onItemClickListener.onClick(investments[position].id)
            }

            if (investments[position].status != "Active") {
                withdrawButton.isVisible = true
                infoButton.isVisible = false
            } else {
                withdrawButton.isVisible = false
                infoButton.isVisible = true
            }

        }
    }

    override fun getItemCount() = investments.size

    interface OnItemClickListener {
        fun onClick(data: String)
    }
}