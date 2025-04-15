package com.miroinvest.testproject.ui.investment

import android.os.Bundle
import android.view.View
import android.widget.SeekBar
import android.widget.SeekBar.OnSeekBarChangeListener
import com.miroinvest.testproject.core.BaseFragment
import com.miroinvest.testproject.databinding.FragmentInvestmentBinding
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class InvestmentFragment :
    BaseFragment<FragmentInvestmentBinding>(FragmentInvestmentBinding::inflate) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)



        val bundle = arguments
        if (bundle != null) {
            planId = bundle.getString("plan_id").toString()
            initPlanDetails(planId)
        }

        with(binding) {
            seekbar.min = 500
            seekbar.max = 5000
            seekbar.setOnSeekBarChangeListener(object : OnSeekBarChangeListener {
                override fun onProgressChanged(seekBar: SeekBar, progress: Int, fromUser: Boolean) {
                    amount.setText(progress.toString())
                }

                override fun onStartTrackingTouch(seekBar: SeekBar) {}

                override fun onStopTrackingTouch(seekBar: SeekBar) {}
            })
        }
    }

    private fun initPlanDetails(planName: String) {
        with(binding) {
            with(toolBar) {
                title.text = planName
                backButton.setOnClickListener {
                    navigateUp()
                }
            }
            seekbar.min = 500
            seekbar.max = 5000
            seekbar.setOnSeekBarChangeListener(object : OnSeekBarChangeListener {
                override fun onProgressChanged(seekBar: SeekBar, progress: Int, fromUser: Boolean) {
                    amount.setText(progress.toString())
                }

                override fun onStartTrackingTouch(seekBar: SeekBar) {}

                override fun onStopTrackingTouch(seekBar: SeekBar) {}
            })
        }
    }

    companion object {
        private const val TAG = "InvestmentFragment"
        private var planId = ""
    }
}