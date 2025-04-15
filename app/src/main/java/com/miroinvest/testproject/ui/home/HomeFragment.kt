package com.miroinvest.testproject.ui.home

import android.content.Context
import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.miroinvest.data.models.PlanEntity
import com.miroinvest.testproject.R
import com.miroinvest.testproject.core.BaseFragment
import com.miroinvest.testproject.core.utils.SampleData
import com.miroinvest.testproject.databinding.FragmentHomeBinding
import com.miroinvest.testproject.ui.adapters.PlansAdapter
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlin.jvm.Throws


@AndroidEntryPoint
class HomeFragment : BaseFragment<FragmentHomeBinding>(FragmentHomeBinding::inflate) {
    private var onPlanClickListener: PlansAdapter.OnPlanClickListener? = null

    private val homeViewModel: HomeViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        buildPlansList()
    }

    private fun buildPlansList() {
        CoroutineScope(Dispatchers.Main).launch {
            try {
                val investPlans = homeViewModel.getInvestmentPlans()
                with(binding) {
                    plansRecyclerView.apply {
                        layoutManager = LinearLayoutManager(requireContext())
                        adapter = PlansAdapter(
                            investPlans,
                            object : PlansAdapter.OnPlanClickListener {
                                override fun onClick(data: String) {
                                    navigateWithBundle(
                                        R.id.action_homeFragment_to_investmentFragment,
                                        Bundle().apply { putString("plan_id", data) })
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
        if (context is PlansAdapter.OnPlanClickListener) {
            onPlanClickListener = context
        }
    }


    companion object {
        private const val TAG = "HomeFragment"
    }
}