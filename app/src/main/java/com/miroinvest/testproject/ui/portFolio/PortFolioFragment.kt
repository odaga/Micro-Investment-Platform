package com.miroinvest.testproject.ui.portFolio

import android.os.Bundle
import android.view.View
import com.miroinvest.testproject.core.BaseFragment
import com.miroinvest.testproject.databinding.FragmentPortFolioBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class PortFolioFragment : BaseFragment<FragmentPortFolioBinding>(FragmentPortFolioBinding::inflate){

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }
}