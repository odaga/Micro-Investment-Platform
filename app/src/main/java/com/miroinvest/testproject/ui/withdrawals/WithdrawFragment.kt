package com.miroinvest.testproject.ui.withdrawals

import android.os.Bundle
import android.view.View
import com.miroinvest.testproject.core.BaseFragment
import com.miroinvest.testproject.databinding.FragmentWithdrawBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class WithdrawFragment : BaseFragment<FragmentWithdrawBinding>(FragmentWithdrawBinding::inflate) {


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }

    companion object {
        private const val TAG = "Withdraw Fragment"
    }
}