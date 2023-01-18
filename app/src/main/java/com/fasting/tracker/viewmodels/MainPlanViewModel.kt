package com.fasting.tracker.viewmodels

import androidx.lifecycle.ViewModel
import com.fasting.tracker.usecases.PlanColor
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject
@HiltViewModel
class MainPlanViewModel @Inject constructor(val planColor: PlanColor): ViewModel() {
    // TODO: Implement the ViewModel
}