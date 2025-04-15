package com.miroinvest.testproject.ui.portFolio

import android.content.Context
import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.miroinvest.data.util.LocalConstants.dummyInvestments
import com.miroinvest.testproject.R
import com.miroinvest.testproject.core.BaseFragment
import com.miroinvest.testproject.databinding.FragmentPortFolioBinding
import com.miroinvest.testproject.ui.adapters.InvestmentsAdapter
import com.miroinvest.testproject.ui.adapters.PlansAdapter
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

@AndroidEntryPoint
class PortFolioFragment :
    BaseFragment<FragmentPortFolioBinding>(FragmentPortFolioBinding::inflate) {

    private var onItemClickListener: InvestmentsAdapter.OnItemClickListener? = null
    private val viewModel: PortFolioViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        with(binding.toolBar) {
            title.text = "My PortFolio"
            backButton.setOnClickListener {
                navigateUp()
            }
        }

        buildInvestmentsList()
    }

    private fun buildInvestmentsList() {
        CoroutineScope(Dispatchers.Main).launch {
            try {
                val investPlans = viewModel.getInvestments()
                with(binding) {
                    investmentsRecyclerView.apply {
                        layoutManager = LinearLayoutManager(requireContext())
                        adapter = InvestmentsAdapter(
                            investPlans,
                            object : InvestmentsAdapter.OnItemClickListener {
                                override fun onClick(data: String) {
                                    navigateWithBundle(
                                        R.id.action_portFolioFragment_to_withdrawFragment,
                                        null
                                    )
//                                    navigateWithBundle(
//                                        R.id.action_homeFragment_to_investmentFragment,
//                                        Bundle().apply { putString("investment_id", data) })
                                }
                            }
                        )
                    }
                }
            } catch (e: Exception) {
                showErrorDialog(e.toString())
            }
        }
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        if (context is InvestmentsAdapter.OnItemClickListener) {
            onItemClickListener = context
        }
    }
}