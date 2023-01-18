package com.fasting.tracker.data.models

import android.content.res.ColorStateList
import android.graphics.drawable.GradientDrawable

data class PlanSevenDaysModel (val title:String, val subtitle:String, val icon:Int, val color:GradientDrawable, val subPlanSevenDaysModel: List<SubPlanSevenDaysModel>)
