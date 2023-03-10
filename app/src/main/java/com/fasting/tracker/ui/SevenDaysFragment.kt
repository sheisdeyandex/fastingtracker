package com.fasting.tracker.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.fasting.tracker.R
import com.fasting.tracker.data.models.PlansModel
import com.fasting.tracker.data.models.SubPlanModel
import com.fasting.tracker.databinding.FragmentSevenDaysBinding
import com.fasting.tracker.databinding.FragmentTwentyEightDaysBinding
import com.fasting.tracker.ui.adapter.PlanAdapter
import com.fasting.tracker.viewmodels.SevenDaysViewModel
import com.zhuinden.fragmentviewbindingdelegatekt.viewBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SevenDaysFragment : Fragment(R.layout.fragment_seven_days) {

    private val viewModel: SevenDaysViewModel by viewModels()

    private val binding: FragmentSevenDaysBinding by viewBinding(
        FragmentSevenDaysBinding::bind)

    private val adapter by lazy { PlanAdapter() }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.rvPlan.layoutManager=
            LinearLayoutManager (requireContext(), LinearLayoutManager.VERTICAL,false)
        binding.rvPlan.adapter= adapter
        adapter.differ.submitList(create7DaysList())
    }
    fun create7DaysList():List<PlansModel>{
        val newList = ArrayList<PlansModel>()
        val subPlanModelList = ArrayList<SubPlanModel>()
        subPlanModelList.add(SubPlanModel("12/12","12 ч. голодания","12 ч. для приёма пищи", R.drawable.fork_and_spoon_1, R.drawable.dish_sub_plan, R.drawable.diamond1))
        subPlanModelList.add(SubPlanModel("13/11","13 ч. голодания","11 ч. для приёма пищи",R.drawable.fork_and_spoon_1, R.drawable.dish_sub_plan, R.drawable.diamond1))
        subPlanModelList.add(SubPlanModel("14/10","14 ч. голодания", "10 ч. для приёма пищи", R.drawable.fork_and_spoon_1, R.drawable.dish_sub_plan, R.drawable.diamond1))
        subPlanModelList.add(SubPlanModel("15/9","15 ч. голодания","9 ч. для приёма пищи", R.drawable.fork_and_spoon_1, R.drawable.dish_sub_plan, R.drawable.diamond1))

        val subPlanModelListExperienced = ArrayList<SubPlanModel>()
        subPlanModelListExperienced.add(SubPlanModel("16/8","16 ч. голодания", "8 ч. для приёма пищи", R.drawable.fork_and_spoon_1, R.drawable.dish_sub_plan, R.drawable.diamond2))
        subPlanModelListExperienced.add(SubPlanModel("17/7","17 ч. голодания", "7 ч. для приёма пищи", R.drawable.fork_and_spoon_1, R.drawable.dish_sub_plan, R.drawable.diamond2))
        subPlanModelListExperienced.add(SubPlanModel("18/6","18 ч. голодания", "6 ч. для приёма пищи", R.drawable.fork_and_spoon_1, R.drawable.dish_sub_plan, R.drawable.diamond2))
        subPlanModelListExperienced.add(SubPlanModel("19/5","19 ч. голодания", "5 ч. для приёма пищи", R.drawable.fork_and_spoon_1, R.drawable.dish_sub_plan, R.drawable.diamond2))

        val subPlanModelListExpert = ArrayList<SubPlanModel>()
        subPlanModelListExpert.add(SubPlanModel("20/4","20 ч. голодания","4 ч. для приёма пищи", R.drawable.fork_and_spoon_1, R.drawable.dish_sub_plan, R.drawable.diamond3))
        subPlanModelListExpert.add(SubPlanModel("21/3","21 ч. голодания","3 ч. для приёма пищи",R.drawable.fork_and_spoon_1, R.drawable.dish_sub_plan, R.drawable.diamond3))
        subPlanModelListExpert.add(SubPlanModel("21/3","21 ч. голодания","3 ч. для приёма пищи",R.drawable.fork_and_spoon_1, R.drawable.dish_sub_plan, R.drawable.diamond3))
        subPlanModelListExpert.add(SubPlanModel("21/3","21 ч. голодания","3 ч. для приёма пищи",R.drawable.fork_and_spoon_1, R.drawable.dish_sub_plan, R.drawable.diamond3))

        newList.add(
            PlansModel(
                getString(R.string.for_beginners),
                getString(R.string.for_beginners_subtitle),R.drawable.forbeginners_apple,viewModel.planColor.forBeginners(requireContext()),subPlanModelList)
        )
        newList.add(
            PlansModel(
                getString(R.string.forexperienced),
                getString(R.string.choseofall),R.drawable.fornormal_grusha,viewModel.planColor.forExperienced(requireContext()),subPlanModelListExperienced)
        )
        newList.add(
            PlansModel(
                getString(R.string.forexperienced),
                getString(R.string.choseofall),R.drawable.fornormal_grusha,viewModel.planColor.forExperienced(requireContext()),subPlanModelListExperienced)
        )
        return newList
    }
}
