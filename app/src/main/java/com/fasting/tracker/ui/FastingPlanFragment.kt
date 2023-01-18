package com.fasting.tracker.ui

import android.os.Bundle
import android.view.View
import android.widget.RadioButton
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupWithNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.fasting.tracker.R
import com.fasting.tracker.data.models.PlansModel
import com.fasting.tracker.data.models.SubPlanModel
import com.fasting.tracker.databinding.FragmentFastingPlanBinding
import com.fasting.tracker.ui.adapter.PlanAdapter
import com.fasting.tracker.viewmodels.FastingPlanViewModel
import com.zhuinden.fragmentviewbindingdelegatekt.viewBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class FastingPlanFragment : Fragment(
    R.layout.fragment_fasting_plan
) {



    private  val viewModel: FastingPlanViewModel by viewModels()

    private val binding: FragmentFastingPlanBinding by viewBinding(FragmentFastingPlanBinding::bind)
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val navHostFragment =
            childFragmentManager.findFragmentById(R.id.nav_host_fragment) as NavHostFragment
        val navController = navHostFragment.navController
        binding.bnvTopMenu.setupWithNavController(navController)
    }

}