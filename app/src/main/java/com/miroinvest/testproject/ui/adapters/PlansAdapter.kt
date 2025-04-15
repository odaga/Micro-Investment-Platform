package com.miroinvest.testproject.ui.adapters

import android.app.Activity
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.miroinvest.data.models.PlanEntity
import com.miroinvest.testproject.R
import com.miroinvest.testproject.databinding.PlanItemRowBinding

class PlansAdapter(
    private val plans: List<PlanEntity>,
    private val onPlanClickListener: OnPlanClickListener?,
) : RecyclerView.Adapter<PlansAdapter.PlanViewHolder>() {

    inner class PlanViewHolder(binding: PlanItemRowBinding) : RecyclerView.ViewHolder
        (binding.root) {
        val planName: TextView = itemView.findViewById(R.id.investment_type)
        val investButton: Button = itemView.findViewById(R.id.button_invest)
        val minimumAmount: TextView = itemView.findViewById(R.id.minimum_investment)
        val returnRate: TextView = itemView.findViewById(R.id.return_rate)
        val lockPeriod: TextView = itemView.findViewById(R.id.lock_period)
    }


    interface OnPlanClickListener {
        fun onClick(data: String)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PlanViewHolder {
        return PlanViewHolder(
            PlanItemRowBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun getItemCount() = plans.size

    override fun onBindViewHolder(holder: PlanViewHolder, position: Int) {
        with(holder) {
            investButton.setOnClickListener {
                onPlanClickListener?.onClick(plans[position].id)
            }

            minimumAmount.text = plans[position].minAmount
            returnRate.text = plans[position].returnRate
            lockPeriod.text = plans[position].lockPeriod
            planName.text = plans[position].name
        }
    }
}
